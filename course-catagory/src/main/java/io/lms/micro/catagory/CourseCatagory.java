package io.lms.micro.catagory;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.scheduling.annotation.EnableScheduling;

import io.lms.micro.BaseServiceConfiguration;

/**
 * <p>
 * <b>Overview:</b>
 * <p>
 * 
 * 
 * <pre>
 * &#64;projectName CourseCatagory
 * &#64;class CourseCatagory
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
@EnableDiscoveryClient
@EnableScheduling
@Import(BaseServiceConfiguration.class)
@SpringBootApplication(exclude = { org.springframework.boot.autoconfigure.security.SecurityAutoConfiguration.class,
		org.springframework.boot.actuate.autoconfigure.ManagementWebSecurityAutoConfiguration.class })
@ComponentScan(useDefaultFilters = true, basePackages = {})
public class CourseCatagory {

	public static void main(String[] args) {
		SpringApplication.run(CourseCatagory.class, args);
	}

}
