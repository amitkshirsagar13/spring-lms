package io.lms.catagory.micro;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Controller;

import io.lms.micro.BaseServiceConfiguration;
import io.lms.micro.services.server.base.BaseServer;

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
@Import(BaseServiceConfiguration.class)
@Controller
@SpringBootApplication(exclude = { org.springframework.boot.autoconfigure.security.SecurityAutoConfiguration.class,
		org.springframework.boot.actuate.autoconfigure.ManagementWebSecurityAutoConfiguration.class })
public class CourseCatagoryServer extends BaseServer {
	public static void main(String[] args) {
		SpringApplication.run(CourseCatagoryServer.class, args);
	}
}
