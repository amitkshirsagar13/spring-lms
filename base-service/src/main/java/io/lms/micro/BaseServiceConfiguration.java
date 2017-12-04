package io.lms.micro;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import io.lms.micro.services.server.base.SwaggerConfiguration;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * <p>
 * <b>Overview:</b>
 * <p>
 * 
 * 
 * <pre>
 * &#64;projectName base-service
 * Creation date: Dec 1, 2017
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
@ComponentScan({ "io.lms.micro" })
public class BaseServiceConfiguration extends SwaggerConfiguration {

}
