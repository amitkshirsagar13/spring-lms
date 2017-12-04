package io.lms.model;

/**
 * <p>
 * <b>Overview:</b>
 * <p>
 * 
 * 
 * <pre>
 * &#64;projectName DatasyncMicroService
 * &#64;class Response
 * Creation date: Jan 24, 2017
 * &#64;author Amit Kshirsagar
 * &#64;version 1.0
 * &#64;since
 * 
 * <p><b>Modification History:</b><p>
 * 
 * 
 * </pre>
 */

public class Response<T> extends BaseEntity {

	private String error;
	private T payload;

	/**
	 * @return the payload
	 */
	public T getPayload() {
		return payload;
	}

	/**
	 * @param payload
	 *            the payload to set
	 */
	public Response setPayload(T payload) {
		this.payload = payload;
		return this;
	}

	/**
	 * @return the error
	 */
	public String getError() {
		return error;
	}

	/**
	 * @param error
	 *            the error to set
	 */
	public Response setError(String error) {
		this.error = error;
		return this;
	}
}
