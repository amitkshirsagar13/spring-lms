package io.lms.turbine.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.turbine.stream.EnableTurbineStream;
import org.springframework.context.annotation.ComponentScan;

/**
 * 
 * <p>
 * <b>Overview:</b>
 * <p>
 * 
 * 
 * <pre>
 * &#64;projectName turbine-service
 * &#64;class TurbineApplication
 * Creation date: Dec 8, 2017
 * &#64;author Amit Kshirsagar
 * &#64;version 1.0
 * &#64;since
 * 
 * <p><b>Modification History:</b><p>
 * 
 * 
 * </pre>
 */
@SpringBootApplication
@EnableEurekaClient
@EnableTurbineStream
@ComponentScan(useDefaultFilters = true, basePackages = { "io.lms.turbine.security" })
public class TurbineApplication {
	public static void main(String[] args) {
		SpringApplication.run(TurbineApplication.class, args);
	}
}