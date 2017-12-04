package io.lms.hibernate;

import java.util.Date;

/**
 * 
 * <p>
 * <b>Overview:</b>
 * <p>
 * 
 * 
 * <pre>
 * &#64;projectName DatasyncMicroService
 * &#64;class PersistModifiable
 * Creation date: Dec 30, 2016
 * &#64;author Amit Kshirsagar
 * &#64;version 1.0
 * &#64;since
 * 
 * <p><b>Modification History:</b><p>
 * 
 * 
 * </pre>
 */

public interface PersistModifiable {

	public void setCreatedDate(Date date);

	public void setUpdatedDate(Date date);

	public void setDeleted(boolean deleted);

	public Date getCreatedDate();

	public Date getUpdatedDate();

	public boolean isDeleted();
}
