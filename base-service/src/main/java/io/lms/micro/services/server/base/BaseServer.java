package io.lms.micro.services.server.base;

import java.util.concurrent.Executor;

import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.stereotype.Controller;

import io.lms.logging.BaseLogger;

/**
 * <p>
 * <b>Overview:</b>
 * <p>
 * 
 * 
 * <pre>
 * &#64;projectName DatasyncMicroService
 * &#64;class BaseServer
 * Creation date: Jan 30, 2017
 * &#64;author Amit Kshirsagar
 * &#64;version 1.0
 * &#64;since
 * 
 * <p><b>Modification History:</b><p>
 * 
 * 
 * </pre>
 */

@EnableAutoConfiguration
@SpringBootApplication
@EnableDiscoveryClient
@EnableCircuitBreaker
@EnableResourceServer
@EnableScheduling
@EnableHystrix
@Controller
@ComponentScan(useDefaultFilters = true, basePackages = { "io.lms.actuator", "io.lms.hibernate", "io.lms.jms",
		"io.lms.security", "io.lms.scheduler", "io.lms.hibernate.repository", "io.lms.hibernate.repository.impl",
		"io.lms.utils" })
@PropertySources(value = { @PropertySource("classpath:/application.properties") })
@Import(io.lms.hystrix.HystrixConfiguration.class)
public class BaseServer extends BaseLogger implements AsyncConfigurer {

	/*
	 * (non-Javadoc)
	 *
	 * @see org.springframework.scheduling.annotation.AsyncConfigurer#
	 * getAsyncExecutor()
	 */
	@Override
	public Executor getAsyncExecutor() {
		ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
		executor.setCorePoolSize(4);
		executor.setMaxPoolSize(6);
		executor.setQueueCapacity(500);
		executor.setThreadNamePrefix("WebhookLookup-");
		executor.initialize();
		return executor;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see org.springframework.scheduling.annotation.AsyncConfigurer#
	 * getAsyncUncaughtExceptionHandler()
	 */
	@Override
	public AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler() {
		return null;
	}
}
