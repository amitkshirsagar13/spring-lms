package io.lms.model;

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
 * &#64;class RequestHeaderInfo
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
public class KinesisRequestHeaderInfo {
	private String AppKey;
	private String Source;
	private String TransactionID;

	/**
	 * @return the appKey
	 */
	public String getAppKey() {
		return AppKey;
	}

	/**
	 * @param appKey
	 *            the appKey to set
	 */
	public void setAppKey(String appKey) {
		this.AppKey = appKey;
	}

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
	 * @return the transactionID
	 */
	public String getTransactionID() {
		return TransactionID;
	}

	/**
	 * @param transactionID
	 *            the transactionID to set
	 */
	public void setTransactionID(String transactionID) {
		this.TransactionID = transactionID;
	}
}
