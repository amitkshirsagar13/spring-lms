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
 * &#64;class ExternalSystemInfo
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
public class ExternalSystemInfo {
	private String SystemID;

	private String SystemName;

	public void setSystemID(String SystemID) {
		this.SystemID = SystemID;
	}

	public String getSystemID() {
		return this.SystemID;
	}

	public void setSystemName(String SystemName) {
		this.SystemName = SystemName;
	}

	public String getSystemName() {
		return this.SystemName;
	}
}
