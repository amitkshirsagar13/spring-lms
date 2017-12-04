package io.lms.micro.services.server.micro;

import org.springframework.beans.factory.annotation.Autowired;
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
 * &#64;projectName DatasyncMicroService
 * &#64;class BaseWebService
 * Creation date: Feb 6, 2017
 * &#64;author Amit Kshirsagar
 * &#64;version 1.0
 * &#64;since
 * 
 * <p><b>Modification History:</b><p>
 * 
 * 
 * </pre>
 */

public class BaseWebService extends BaseLogger {
	@Autowired
	protected AsyncRestTemplate asyncRestTemplate;

	@Autowired
	protected RestTemplate restTemplate;

}
