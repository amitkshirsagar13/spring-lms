/**
 * 
 */
package io.lms.oauth2.model;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * <p>
 * <b>Overview:</b>
 * <p>
 * 
 * 
 * <pre>
 * &#64;projectName oauth-service
 * Creation date: Jun 20, 2018
 * &#64;author Amit Kshirsagar
 * &#64;version 1.0
 * &#64;since
 * 
 * <p><b>Modification History:</b><p>
 * 
 * 
 * </pre>
 */

public class Response<T> {

	private T responseItem;

	/**
	 * @return the responseItem
	 */
	public T getResponseItem() {
		return responseItem;
	}

	/**
	 * @param responseItem
	 *            the responseItem to set
	 */
	public Response<T> setResponseItem(T responseItem) {
		this.responseItem = responseItem;
		return this;
	}

	@Override
	public String toString() {
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		return gson.toJson(this);
	}
}
