package io.lms.rest.templete;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.task.SimpleAsyncTaskExecutor;
import org.springframework.http.client.AsyncClientHttpRequestFactory;
import org.springframework.http.client.AsyncClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.AsyncRestTemplate;
import org.springframework.web.client.RestTemplate;

import io.lms.logging.BaseLogger;

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
public class TempleteProvider extends BaseLogger {

	/**
	 * A customized RestTemplate that has the ribbon load balancer build in. Note
	 * that prior to the "Brixton"
	 * 
	 * @return
	 */
	@LoadBalanced
	@Bean
	public AsyncRestTemplate asyncRestTemplate(@LoadBalanced @Autowired RestTemplate restTemplate) {
		AsyncClientHttpRequestFactory asyncClientHttpRequestFactory = new SimpleClientHttpRequestFactory();
		((SimpleClientHttpRequestFactory) asyncClientHttpRequestFactory).setTaskExecutor(new SimpleAsyncTaskExecutor());
		AsyncRestTemplate asyncRestTemplate = new AsyncRestTemplate(asyncClientHttpRequestFactory, restTemplate);

		for (ClientHttpRequestInterceptor interceptor : restTemplate.getInterceptors()) {
			logInfo("restTemplate:" + interceptor);
		}
		for (AsyncClientHttpRequestInterceptor interceptor : asyncRestTemplate.getInterceptors()) {
			logInfo("asyncRestTemplate:" + interceptor);
		}
		// asyncRestTemplate.setInterceptors(restTemplate.getInterceptors());
		return asyncRestTemplate;
	}

	@LoadBalanced
	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

}
