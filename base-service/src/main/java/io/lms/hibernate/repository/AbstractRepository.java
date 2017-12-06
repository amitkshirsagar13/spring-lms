package io.lms.hibernate.repository;

/**
 * <p>
 * <b>Overview:</b>
 * <p>
 * 
 * 
 * <pre>
 * &#64;projectName DatasyncMicroService
 * &#64;class AbstractRepository
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

public interface AbstractRepository<T> {

	public String getCollectionName();

	public void cleanup();

	// public void markSuccessFailEntity(Exchange exchange);

	// public void markProcessingEntity(Exchange exchange);
}
