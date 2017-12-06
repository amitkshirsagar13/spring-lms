package io.lms.hibernate.repository.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import io.lms.hibernate.repository.AbstractRepository;
import io.lms.logging.BaseLogger;
import io.lms.model.BaseEntity;

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

public abstract class AbstractRepositoryImpl<PK extends Serializable, T> extends BaseLogger
		implements AbstractRepository {
	@SuppressWarnings("unchecked")
	public AbstractRepositoryImpl() {
		this.persistentClass = (Class<T>) ((ParameterizedType) this.getClass().getGenericSuperclass())
				.getActualTypeArguments()[1];
	}

	private Class<T> persistentClass;

	@Autowired
	private MongoOperations mongoOperations;

	public void persistToMongo(T entity) {
		logDebug("[persistToMongo]:" + entity);
		getMongoOperations().save(entity, getCollectionName());
	}

	public MongoOperations getMongoOperations() {
		return mongoOperations;
	}

	public void setMongoOperations(MongoOperations mongoOperations) {
		this.mongoOperations = mongoOperations;
	}

	@Override
	public void cleanup() {
		if (getMongoOperations() != null) {
			Query searchUserQuery = new Query(Criteria.where("status").is("success"));
			getMongoOperations().findAllAndRemove(searchUserQuery, persistentClass, getCollectionName());
		}
	}

	// @Override
	// public void markSuccessFailEntity(Exchange exchange) {
	// Response entity = (Response) exchange.getIn().getBody();
	// logDebug("Saving Camel Route Identity markSuccessFailEntity...." +
	// ((BaseEntity) entity).toStringNoPretty());
	// if (entity.getStatus().equalsIgnoreCase("success")) {
	// ((BaseEntity) entity.getPayload()).setStatus("success");
	// } else {
	// ((BaseEntity) entity.getPayload()).setStatus("failure");
	// }
	// persistToMongo((T) entity.getPayload());
	// }

	// @Override
	// public void markProcessingEntity(Exchange exchange) {
	// T entity = (T) exchange.getIn().getBody();
	// ((BaseEntity) entity).setStatus("processing");
	// logDebug("Saving Camel Route Identity markProcessingEntity...." +
	// ((BaseEntity) entity).toStringNoPretty());
	// persistToMongo(entity);
	// }

	public List<T> getEntityForProcessing(Query searchUserQuery) {
		List<T> entityList = new ArrayList<>();
		if (searchUserQuery != null) {
			entityList = getMongoOperations().find(searchUserQuery, persistentClass, getCollectionName());
		} else {
			logWarn("Query with null criteria for .... " + getCollectionName());
		}
		return entityList;
	}

	public BaseEntity find(BaseEntity baseEntity) {
		Query searchUserQuery = null;
		if (getMongoOperations() != null) {
			Criteria criteria = new Criteria().is(Criteria.where("_id")).is(baseEntity.getId());
			searchUserQuery = new Query(criteria);
		}
		return (BaseEntity) getMongoOperations().findOne(searchUserQuery, persistentClass, getCollectionName());
	}
}
