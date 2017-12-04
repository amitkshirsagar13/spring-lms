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
 * &#64;class Details
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
public class Details {
	private String ProductID;

	private String Status;

	private List<String> ServiceablePropertyIDs;

	private String PricingOverride;

	private List<Attributes> Attributes;

	public void setProductID(String ProductID) {
		this.ProductID = ProductID;
	}

	public String getProductID() {
		return this.ProductID;
	}

	public void setStatus(String Status) {
		this.Status = Status;
	}

	public String getStatus() {
		return this.Status;
	}

	public void setServiceablePropertyIDs(List<String> ServiceablePropertyIDs) {
		this.ServiceablePropertyIDs = ServiceablePropertyIDs;
	}

	public List<String> getServiceablePropertyIDs() {
		return this.ServiceablePropertyIDs;
	}

	public void setPricingOverride(String PricingOverride) {
		this.PricingOverride = PricingOverride;
	}

	public String getPricingOverride() {
		return this.PricingOverride;
	}

	public void setAttributes(List<Attributes> Attributes) {
		this.Attributes = Attributes;
	}

	public List<Attributes> getAttributes() {
		return this.Attributes;
	}
}
