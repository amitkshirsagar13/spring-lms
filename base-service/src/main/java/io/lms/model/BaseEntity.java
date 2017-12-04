package io.lms.model;

import java.util.Date;

import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

import org.springframework.data.annotation.Id;

import com.fasterxml.jackson.annotation.JsonFormat;

import io.lms.hibernate.PersistModifiable;
import io.swagger.annotations.ApiModelProperty;

/**
 * <p>
 * <b>Overview:</b>
 * <p>
 * 
 * 
 * <pre>
 * &#64;projectName DatasyncMicroService
 * &#64;class BaseEntity
 * Creation date: Feb 2, 2017
 * &#64;author Amit Kshirsagar
 * &#64;version 1.0
 * &#64;since
 * 
 * <p><b>Modification History:</b><p>
 * 
 * 
 * </pre>
 */

@MappedSuperclass
public class BaseEntity extends Entity implements PersistModifiable {

	@Id
	@ApiModelProperty(required = false, hidden = true)
	private String id;

	private String recordId;

	public String getRecordId() {
		return id;
	}

	public void setRecordId(String recordId) {
		// this.recordId = recordId;
	}

	@ApiModelProperty(required = false, hidden = true)
	private String status;

	@ApiModelProperty(required = false, hidden = true)
	@JsonFormat(pattern = "MMM dd, yyyy hh:mm:ss a")
	private Date createdDate;

	@ApiModelProperty(required = false, hidden = true)
	@JsonFormat(pattern = "MMM dd, yyyy hh:mm:ss a")
	private Date updatedDate;

	@ApiModelProperty(required = false, hidden = true)
	private boolean deleted;

	@Override
	public Date getCreatedDate() {
		return this.createdDate;
	}

	@Override
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	@Override
	public boolean isDeleted() {
		return this.deleted;
	}

	@Override
	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}

	@Override
	public Date getUpdatedDate() {
		return this.updatedDate;
	}

	@Override
	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

	@PrePersist
	protected void onCreate() {
		createdDate = new Date();
		deleted = false;
	}

	@PreUpdate
	protected void onUpdate() {
		updatedDate = new Date();
	}

	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @param status
	 *            the status to set
	 */
	public BaseEntity setStatus(String status) {
		this.status = status;
		return this;
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
