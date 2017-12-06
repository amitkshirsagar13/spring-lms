package io.lms.micro.services.server.base;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.core.env.Environment;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import io.swagger.models.Contact;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.AuthorizationScope;
import springfox.documentation.service.SecurityReference;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * 
 * <p>
 * <b>Overview:</b>
 * <p>
 * 
 * 
 * <pre>
 * &#64;projectName DatasyncMicroService
 * &#64;class SwaggerConfig
 * Creation date: Jan 24, 2017
 * &#64;author Amit Kshirsagar
 * &#64;version 1.0
 * &#64;since
 * 
 * <p><b>Modification History:</b><p>
 * 
 * 
 * </pre>
 */
@RefreshScope
@Configuration
@EnableSwagger2
@ComponentScan({ "io.lms.jms", "io.lms.jms.queue", "io.lms.micro.services.web.swagger", "io.lms.model", "io.lms.oauth2",
		"io.lms.security", "io.lms.hibernate", "io.lms.hibernate.aop", "io.lms.hibernate.repository" })
@Import(io.lms.hystrix.HystrixConfiguration.class)
@EnableConfigurationProperties
public abstract class SwaggerConfiguration extends WebMvcConfigurerAdapter {

	@Value("${server.port}")
	int port;

	@Value("${server.hostname}")
	String hostname;

	@Autowired
	Environment environment;

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("swagger-ui.html").addResourceLocations("classpath:/META-INF/resources/");
		registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
		registry.addResourceHandler("/static/**").addResourceLocations("/static/");
	}

	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2).groupName("All").select().apis(RequestHandlerSelectors.any())
				.paths(PathSelectors.regex("/api/*/.*")).build().apiInfo(apiInfo())
				.securitySchemes(newArrayList(apiKey())).securityContexts(newArrayList(securityContext()))
				.forCodeGeneration(true).host(getHostname() + ":" + getPort());
	}

	private ApiKey apiKey() {
		return new ApiKey("Authorization", "Authorization", "header");
	}

	private SecurityContext securityContext() {
		return SecurityContext.builder().securityReferences(defaultAuth()).forPaths(PathSelectors.regex("/api/*/.*"))
				.build();
	}

	private <T> List<T> newArrayList(T something) {
		List<T> list = new ArrayList<T>();
		list.add(something);

		return list;
	}

	List<SecurityReference> defaultAuth() {
		AuthorizationScope authorizationScope = new AuthorizationScope("global", "accessEverything");
		AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
		authorizationScopes[0] = authorizationScope;
		return newArrayList(new SecurityReference("Authorization", authorizationScopes));
	}
	//
	// @Bean
	// SecurityConfiguration security() {
	// return new SecurityConfiguration(null, null, null, // realm Needed for
	// authenticate button to work
	// null, // appName Needed for authenticate button to work
	// null, // apiKeyValue
	// ApiKeyVehicle.HEADER, "Authorization", // apiKeyName
	// null);
	// }

	public abstract ApiInfo apiInfo();

	public ApiInfoBuilder apiInfoBuilder() {
		Contact contact = new Contact();
		contact.setName("Amit Kshirsagar");
		contact.setEmail("akshirsa@gmail.com");

		return new ApiInfoBuilder().termsOfServiceUrl("https://" + getHostname() + ":" + getPort() + "/v3")
				.license("LICENSE").licenseUrl("https://" + getHostname() + ":" + getPort() + "/v3");
	}

	/**
	 * @return the port
	 */
	public int getPort() {
		return port;
	}

	/**
	 * @param port
	 *            the port to set
	 */
	public void setPort(int port) {
		this.port = port;
	}

	/**
	 * @return the hostname
	 */
	public String getHostname() {
		return hostname;
	}

	/**
	 * @param hostname
	 *            the hostname to set
	 */
	public void setHostname(String hostname) {
		this.hostname = hostname;
	}

}