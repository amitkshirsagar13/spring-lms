package io.lms.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * <p>
 * <b>Overview:</b>
 * <p>
 * 
 * 
 * <pre>
 * &#64;projectName DatasyncMicroService
 * &#64;class KinesisMessage
 * Creation date: Feb 7, 2017
 * &#64;author Amit Kshirsagar
 * &#64;version 1.0
 * &#64;since
 * 
 * <p><b>Modification History:</b><p>
 * 
 * 
 * </pre>
 * 
 * @param <T>
 */
@Document
public class KinesisMessage<T> extends BaseEntity {
	@Id
	private String id;
	private String shardId;
	private String sequenceNumber;
	// @Transient
	private KinesisData<T> data;

	/**
	 * @return the shardId
	 */
	public String getShardId() {
		return shardId;
	}

	/**
	 * @param shardId
	 *            the shardId to set
	 */
	public void setShardId(String shardId) {
		this.shardId = shardId;
	}

	/**
	 * @return the sequenceNumber
	 */
	public String getSequenceNumber() {
		return sequenceNumber;
	}

	/**
	 * @param sequenceNumber
	 *            the sequenceNumber to set
	 */
	public void setSequenceNumber(String sequenceNumber) {
		this.id = sequenceNumber;
		this.sequenceNumber = sequenceNumber;
	}

	/**
	 * @return the data
	 */
	public KinesisData<T> getData() {
		return data;
	}

	/**
	 * @param data
	 *            the data to set
	 */
	public void setData(KinesisData<T> data) {
		this.data = data;
	}

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

}
