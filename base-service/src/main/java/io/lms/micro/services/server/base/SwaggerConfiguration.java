package io.lms.micro.services.server.base;

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
import springfox.documentation.spi.DocumentationType;
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
@ComponentScan({ "io.lms.jms", "io.lms.jms.queue", "io.lms.micro.services.web.swagger",
		"io.lms.model", "io.lms.hibernate", "io.lms.hibernate.aop",
		"io.lms.hibernate.repository" })
@Import(io.lms.hystrix.HystrixConfiguration.class)
@EnableConfigurationProperties
public class SwaggerConfiguration extends WebMvcConfigurerAdapter {

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
		// if (hostname == null) {
		// hostname = environment.getProperty("server.hostname");
		// port = environment.getProperty("server.port", Integer.class);
		// }

		return new Docket(DocumentationType.SWAGGER_2).groupName("All").select().apis(RequestHandlerSelectors.any())
				.paths(PathSelectors.regex("/api/*/.*")).build().apiInfo(apiInfo()).forCodeGeneration(true)
				.host(getHostname() + ":" + getPort());
	}

	private ApiInfo apiInfo() {
		Contact contact = new Contact();
		contact.setName("Amit Kshirsagar");
		contact.setEmail("akshirsa@gmail.com");

		return new ApiInfoBuilder().title("DataSync micro").description("Datasync micro").version("1.0")
				.termsOfServiceUrl("https://" + getHostname() + ":" + getPort() + "/v3").license("LICENSE")
				.licenseUrl("https://" + getHostname() + ":" + getPort() + "/v3").build();
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