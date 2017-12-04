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
 * &#64;class RelatedEntities
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
public class RelatedEntities {
	private String ObjectID;

	private String ObjectClass;

	private String Role;

	public void setObjectID(String ObjectID) {
		this.ObjectID = ObjectID;
	}

	public String getObjectID() {
		return this.ObjectID;
	}

	public void setObjectClass(String ObjectClass) {
		this.ObjectClass = ObjectClass;
	}

	public String getObjectClass() {
		return this.ObjectClass;
	}

	public void setRole(String Role) {
		this.Role = Role;
	}

	public String getRole() {
		return this.Role;
	}
}