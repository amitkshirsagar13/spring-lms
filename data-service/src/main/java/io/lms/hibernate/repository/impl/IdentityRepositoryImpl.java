package io.lms.hibernate.repository.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import io.lms.hibernate.repository.IdentityRepository;
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
 * Creation date: Jan 26, 2017
 * &#64;author Amit Kshirsagar
 * &#64;version 1.0
 * &#64;since
 * 
 * <p><b>Modification History:</b><p>
 * 
 * 
 * </pre>
 */
@Repository("identityRepository")
public class IdentityRepositoryImpl extends AbstractRepositoryImpl<Integer, KinesisMessage>
		implements IdentityRepository {

	private static String collectionName = "identity_translog";

	@Override
	public void saveIdentity(KinesisMessage identity) {
		persistToMongo(identity);
	}

	@Override
	public void updateIdentity(KinesisMessage identity) {
		persistToMongo(identity);
	}

	@Override
	public List<KinesisMessage> getIdentitiesForProcessing() {
		return getEntityForProcessing();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * io.lms.hibernate.repository.AbstractRepository#getCollectionName()
	 */
	@Override
	public String getCollectionName() {
		return collectionName;
	}
}
