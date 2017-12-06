package io.lms.hibernate.course;

import java.util.List;

import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import io.lms.hibernate.repository.ResourceRepository;
import io.lms.hibernate.repository.impl.AbstractRepositoryImpl;
import io.lms.model.course.CourseCatagory;

/**
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
@Repository(value = "courseCatagoryRepository")
public class CourseCatagoryRepository extends AbstractRepositoryImpl<Integer, CourseCatagory>
		implements ResourceRepository<CourseCatagory> {

	/*
	 * (non-Javadoc)
	 * 
	 * @see io.lms.hibernate.repository.AbstractRepository#getCollectionName()
	 */
	@Override
	public String getCollectionName() {
		return "courseCatagory";
	}

	@Override
	public void saveResource(CourseCatagory baseResourceEntity) {
		persistToMongo(baseResourceEntity);
	}

	@Override
	public void updateResource(CourseCatagory baseResourceEntity) {
		persistToMongo(baseResourceEntity);
	}

	@Override
	public List<CourseCatagory> getResourceList(String id, String name, String metakey, String owner, boolean enabled,
			boolean deleted) {
		Query searchUserQuery = null;
		if (getMongoOperations() != null) {
			Criteria criteria = new Criteria().andOperator(Criteria.where("name").is(name),
					Criteria.where("enabled").exists(enabled), Criteria.where("deleted").exists(deleted));
			criteria = Criteria.where("name").is(name);
			searchUserQuery = new Query(criteria);
		}
		return getEntityForProcessing(searchUserQuery);
	}

}
