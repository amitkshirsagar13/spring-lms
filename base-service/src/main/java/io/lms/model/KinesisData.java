package io.lms.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

/**
 * <p>
 * <b>Overview:</b>
 * <p>
 * 
 * 
 * <pre>
 * &#64;projectName DatasyncMicroService
 * &#64;class KinesisData
 * Creation date: Feb 7, 2017
 * &#64;author Amit Kshirsagar
 * &#64;version 1.0
 * &#64;since
 * 
 * <p><b>Modification History:</b><p>
 * 
 * 
 * </pre>
 */

@JsonNaming(PropertyNamingStrategy.UpperCamelCaseStrategy.class)
public class KinesisData<T> {
	private String Source;
	private String RequestUrl;
	private KinesisRequestHeaderInfo RequestHeaderInfo;

	private T AfterModified;
	private T BeforeModified;
	private T AfterPublished;
	private T BeforePublished;

	private String HTTPVerb;
	private String TimeStamp;

	/**
	 * @return the source
	 */
	public String getSource() {
		return Source;
	}

	/**
	 * @param source
	 *            the source to set
	 */
	public void setSource(String source) {
		this.Source = source;
	}

	/**
	 * @return the requestUrl
	 */
	public String getRequestUrl() {
		return RequestUrl;
	}

	/**
	 * @param requestUrl
	 *            the requestUrl to set
	 */
	public void setRequestUrl(String requestUrl) {
		this.RequestUrl = requestUrl;
	}

	/**
	 * @return the requestHeaderInfo
	 */
	public KinesisRequestHeaderInfo getRequestHeaderInfo() {
		return RequestHeaderInfo;
	}

	/**
	 * @param requestHeaderInfo
	 *            the requestHeaderInfo to set
	 */
	public void setRequestHeaderInfo(KinesisRequestHeaderInfo requestHeaderInfo) {
		this.RequestHeaderInfo = requestHeaderInfo;
	}

	/**
	 * @return the httpVerb
	 */
	@JsonProperty("HTTPVerb")
	public String getHttpVerb() {
		return HTTPVerb;
	}

	/**
	 * @param httpVerb
	 *            the httpVerb to set
	 */
	@JsonProperty("HTTPVerb")
	public void setHttpVerb(String httpVerb) {
		this.HTTPVerb = httpVerb;
	}

	/**
	 * @return the timeStamp
	 */
	public String getTimeStamp() {
		return TimeStamp;
	}

	/**
	 * @param timeStamp
	 *            the timeStamp to set
	 */
	public void setTimeStamp(String timeStamp) {
		this.TimeStamp = timeStamp;
	}

	/**
	 * @return the afterModified
	 */
	public T getAfterModified() {
		return AfterModified;
	}

	/**
	 * @param afterModified
	 *            the afterModified to set
	 */
	public void setAfterModified(T afterModified) {
		this.AfterModified = afterModified;
	}

	/**
	 * @return the beforeModified
	 */
	public T getBeforeModified() {
		return BeforeModified;
	}

	/**
	 * @param beforeModified
	 *            the beforeModified to set
	 */
	public void setBeforeModified(T beforeModified) {
		this.BeforeModified = beforeModified;
	}

	/**
	 * @return the afterPublished
	 */
	public T getAfterPublished() {
		return AfterPublished;
	}

	/**
	 * @param afterPublished
	 *            the afterPublished to set
	 */
	public void setAfterPublished(T afterPublished) {
		this.AfterPublished = afterPublished;
	}

	/**
	 * @return the beforePublished
	 */
	public T getBeforePublished() {
		return BeforePublished;
	}

	/**
	 * @param beforePublished
	 *            the beforePublished to set
	 */
	public void setBeforePublished(T beforePublished) {
		this.BeforePublished = beforePublished;
	}

}
