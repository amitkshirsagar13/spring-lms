package io.lms.oauth2.application;

import java.security.Principal;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * <b>Overview:</b>
 * <p>
 * 
 * 
 * <pre>
 * &#64;projectName eureka-service
 * &#64;class EurekaApplication
 * Creation date: Feb 9, 2017
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
@EnableDiscoveryClient
@ComponentScan({ "io.lms.oauth2" })
@RestController
public class OAuth2Server {
	private static final Log logger = LogFactory.getLog(OAuth2Server.class);

	/**
	 * Run the application using Spring Boot and an embedded servlet engine.
	 * 
	 * @param args
	 *            Program arguments - ignored.
	 */
	public static void main(String[] args) {
		SpringApplication.run(OAuth2Server.class, args);
	}

	@RequestMapping("/user")
	public Principal user(Principal user) {
		logger.info("AS /user has been called");
		logger.debug("user info: " + user.toString());
		return user;
	}
}