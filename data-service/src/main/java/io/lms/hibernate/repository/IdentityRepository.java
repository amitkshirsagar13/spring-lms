package io.lms.hibernate.repository;

import java.util.List;

import io.lms.model.KinesisMessage;

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

public interface IdentityRepository extends AbstractRepository {

	public void saveIdentity(KinesisMessage identity);

	public void updateIdentity(KinesisMessage identity);

	public List<KinesisMessage> getIdentitiesForProcessing();
}
