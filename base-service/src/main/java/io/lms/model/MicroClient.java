package io.lms.model;

import java.util.concurrent.Callable;

import org.springframework.http.HttpEntity;
import org.springframework.web.client.RestTemplate;

import io.swagger.annotations.ApiModelProperty;

/**
 * <p>
 * <b>Overview:</b>
 * <p>
 * 
 * 
 * <pre>
 * &#64;projectName DatasyncMicroService
 * &#64;class MicroClient
 * Creation date: Feb 1, 2017
 * &#64;author Amit Kshirsagar
 * &#64;version 1.0
 * &#64;since
 * 
 * <p><b>Modification History:</b><p>
 * 
 * 
 * </pre>
 */

public class MicroClient extends BaseEntity implements Callable<Response> {

	@ApiModelProperty(required = false, hidden = true)
	protected RestTemplate restTemplate;

	@ApiModelProperty(required = false, hidden = true)
	protected String serviceUrl;

	@ApiModelProperty(required = false, hidden = true)
	public HttpEntity<String> entity;

	public MicroClient() {
	}

	/**
	* 
	*/
	public MicroClient(RestTemplate restTemplate, String serviceUrl, HttpEntity<String> entity) {
		this.restTemplate = restTemplate;
		this.serviceUrl = serviceUrl;
		this.entity = entity;
	}

	/**
	 * @return the restTemplate
	 */
	public RestTemplate getRestTemplate() {
		return restTemplate;
	}

	/**
	 * @param restTemplate
	 *            the restTemplate to set
	 */
	public void setRestTemplate(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}

	/**
	 * @return the serviceUrl
	 */
	public String getServiceUrl() {
		return serviceUrl;
	}

	/**
	 * @param serviceUrl
	 *            the serviceUrl to set
	 */
	public void setServiceUrl(String serviceUrl) {
		this.serviceUrl = serviceUrl;
	}

	/**
	 * @return the entity
	 */
	public HttpEntity<String> getEntity() {
		return entity;
	}

	/**
	 * @param entity
	 *            the entity to set
	 */
	public void setEntity(HttpEntity<String> entity) {
		this.entity = entity;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.util.concurrent.Callable#call()
	 */
	@Override
	public Response call() throws Exception {
		return restTemplate.postForObject(serviceUrl, entity, Response.class);
	}

}
