package io.lms.hibernate.repository;

import java.util.List;

/**
 * <p>
 * <b>Overview:</b>
 * <p>
 * 
 * 
 * <pre>
 * &#64;projectName DatasyncMicroService
 * &#64;class IdentityRepository
 * Creation date: Jan 30, 2017
 * &#64;author Amit Kshirsagar
 * &#64;version 1.0
 * &#64;since
 * 
 * <p><b>Modification History:</b><p>
 * 
 * 
 * </pre>
 */

public interface ResourceRepository<T> extends AbstractRepository {

	public void saveResource(T resource);

	public void updateResource(T resource);

	public List<T> getResourceList(String id, String name, String metakey, String owner, boolean enabled,
			boolean deleted);
}
