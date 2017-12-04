package io.lms.model.course;

import java.util.List;

import io.lms.model.BaseResourceEntity;
import io.swagger.annotations.ApiModelProperty;

/**
 * 
 * <p>
 * <b>Overview:</b>
 * <p>
 * 
 * 
 * <pre>
 * &#64;projectName course-catagory
 * Creation date: Dec 4, 2017
 * &#64;author Amit Kshirsagar
 * &#64;version 1.0
 * &#64;since
 * 
 * <p><b>Modification History:</b><p>
 * 
 * 
 * </pre>
 */
public class CourseCatagory extends BaseResourceEntity {
	@ApiModelProperty(required = false)
	private List<String> organizationList;

	/**
	 * @return the organizationList
	 */
	public List<String> getOrganizationList() {
		return organizationList;
	}

	/**
	 * @param organizationList
	 *            the organizationList to set
	 */
	public void setOrganizationList(List<String> organizationList) {
		this.organizationList = organizationList;
	}

}
