package io.lms.model;

import javax.persistence.MappedSuperclass;

import io.swagger.annotations.ApiModelProperty;

/**
 * 
 * <p>
 * <b>Overview:</b>
 * <p>
 * 
 * 
 * <pre>
 * &#64;projectName base-service
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
@MappedSuperclass
public class BaseResourceEntity extends BaseEntity {
	@ApiModelProperty(required = false)
	private boolean enabled;
	private String owner;
	private String creator;
	@ApiModelProperty(required = false)
	private String lastUpdator;

	private String name;
	private String description;

	@ApiModelProperty(required = false)
	private String metakey;

	/**
	 * @return the enabled
	 */
	public boolean isEnabled() {
		return enabled;
	}

	/**
	 * @param enabled
	 *            the enabled to set
	 */
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	/**
	 * @return the owner
	 */
	public String getOwner() {
		return owner;
	}

	/**
	 * @param owner
	 *            the owner to set
	 */
	public void setOwner(String owner) {
		this.owner = owner;
	}

	/**
	 * @return the creator
	 */
	public String getCreator() {
		return creator;
	}

	/**
	 * @param creator
	 *            the creator to set
	 */
	public void setCreator(String creator) {
		this.creator = creator;
	}

	/**
	 * @return the lastUpdator
	 */
	public String getLastUpdator() {
		return lastUpdator;
	}

	/**
	 * @param lastUpdator
	 *            the lastUpdator to set
	 */
	public void setLastUpdator(String lastUpdator) {
		this.lastUpdator = lastUpdator;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description
	 *            the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the metakey
	 */
	public String getMetakey() {
		return metakey;
	}

	/**
	 * @param metakey
	 *            the metakey to set
	 */
	public void setMetakey(String metakey) {
		this.metakey = metakey;
	}

}
