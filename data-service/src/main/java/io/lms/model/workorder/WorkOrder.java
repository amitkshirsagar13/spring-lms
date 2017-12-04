package io.lms.model.workorder;

import java.util.List;

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
 * &#64;class Identity
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
@JsonNaming(PropertyNamingStrategy.UpperCamelCaseStrategy.class)
public class WorkOrder {

	private String WorkOrderID;

	private String Type;

	private String Status;

	private String ReferenceNumber;

	private String ProductSaleID;

	private String CustomerIdentityID;

	private String CreatedByUserName;

	private String LastModifiedDate;

	private String CreatedDateTime;

	private List<RelatedOrganizations> RelatedOrganizations;

	private List<Details> Details;

	private List<ExternalSystemInfo> ExternalSystemInfo;

	private List<RelatedEntities> RelatedEntities;

	private List<String> Attributes;

	private boolean Deleted;

	public void setWorkOrderID(String WorkOrderID) {
		this.WorkOrderID = WorkOrderID;
	}

	public String getWorkOrderID() {
		return this.WorkOrderID;
	}

	public void setType(String Type) {
		this.Type = Type;
	}

	public String getType() {
		return this.Type;
	}

	public void setReferenceNumber(String ReferenceNumber) {
		this.ReferenceNumber = ReferenceNumber;
	}

	public String getReferenceNumber() {
		return this.ReferenceNumber;
	}

	public void setProductSaleID(String ProductSaleID) {
		this.ProductSaleID = ProductSaleID;
	}

	public String getProductSaleID() {
		return this.ProductSaleID;
	}

	public void setCustomerIdentityID(String CustomerIdentityID) {
		this.CustomerIdentityID = CustomerIdentityID;
	}

	public String getCustomerIdentityID() {
		return this.CustomerIdentityID;
	}

	public void setCreatedByUserName(String CreatedByUserName) {
		this.CreatedByUserName = CreatedByUserName;
	}

	public String getCreatedByUserName() {
		return this.CreatedByUserName;
	}

	public void setLastModifiedDate(String LastModifiedDate) {
		this.LastModifiedDate = LastModifiedDate;
	}

	public String getLastModifiedDate() {
		return this.LastModifiedDate;
	}

	public void setCreatedDateTime(String CreatedDateTime) {
		this.CreatedDateTime = CreatedDateTime;
	}

	public String getCreatedDateTime() {
		return this.CreatedDateTime;
	}

	public void setRelatedOrganizations(List<RelatedOrganizations> RelatedOrganizations) {
		this.RelatedOrganizations = RelatedOrganizations;
	}

	public List<RelatedOrganizations> getRelatedOrganizations() {
		return this.RelatedOrganizations;
	}

	public void setDetails(List<Details> Details) {
		this.Details = Details;
	}

	public List<Details> getDetails() {
		return this.Details;
	}

	public void setExternalSystemInfo(List<ExternalSystemInfo> ExternalSystemInfo) {
		this.ExternalSystemInfo = ExternalSystemInfo;
	}

	public List<ExternalSystemInfo> getExternalSystemInfo() {
		return this.ExternalSystemInfo;
	}

	public void setRelatedEntities(List<RelatedEntities> RelatedEntities) {
		this.RelatedEntities = RelatedEntities;
	}

	public List<RelatedEntities> getRelatedEntities() {
		return this.RelatedEntities;
	}

	public void setAttributes(List<String> Attributes) {
		this.Attributes = Attributes;
	}

	public List<String> getAttributes() {
		return this.Attributes;
	}

	public void setDeleted(boolean Deleted) {
		this.Deleted = Deleted;
	}

	public boolean getDeleted() {
		return this.Deleted;
	}

	/**
	 * @return the status
	 */
	public String getStatus() {
		return Status;
	}

	/**
	 * @param status
	 *            the status to set
	 */
	public void setStatus(String status) {
		this.Status = status;
	}

}
