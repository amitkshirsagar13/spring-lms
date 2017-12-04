package io.lms.model.workorder;

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
 * &#64;class RelatedOrganizations
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
public class RelatedOrganizations {
	private String OrganizationID;

	private int Role;

	public void setOrganizationID(String OrganizationID) {
		this.OrganizationID = OrganizationID;
	}

	public String getOrganizationID() {
		return this.OrganizationID;
	}

	public void setRole(int Role) {
		this.Role = Role;
	}

	public int getRole() {
		return this.Role;
	}
}