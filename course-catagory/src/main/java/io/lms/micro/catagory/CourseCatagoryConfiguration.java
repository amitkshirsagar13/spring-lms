package io.lms.micro.catagory;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import io.lms.micro.services.server.base.SwaggerConfiguration;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * <p>
 * <b>Overview:</b>
 * <p>
 * 
 * 
 * <pre>
 * &#64;projectName course-catagory
 * Creation date: Dec 4, 2017
 * &#64;author Amit Kshirsagar
 * &#64;version 1.0
 * &#64;since
 * 
 * <p><b>Modification History:</b><p>
 * 
 * 
 * </pre>
 */
@Configuration
@EnableSwagger2
@ComponentScan({ "io.lms.micro.catagory" })
public class CourseCatagoryConfiguration extends SwaggerConfiguration {

	/*
	 * (non-Javadoc)
	 * 
	 * @see io.lms.micro.services.server.base.SwaggerConfiguration#apiInfo()
	 */
	@Override
	public ApiInfo apiInfo() {
		return apiInfoBuilder().title("Course Catagory MicroService")
				.description("Course Catagory MicroService for handling Course Catagories").version("1.0").build();
	}

}
