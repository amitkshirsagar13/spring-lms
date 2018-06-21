/**
 * 
 */
package io.lms.oauth2.service;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import io.lms.oauth2.model.AuthorityEntity;

/**
 * <p>
 * <b>Overview:</b>
 * <p>
 * 
 * 
 * <pre>
 * &#64;projectName oauth-service
 * Creation date: Jun 20, 2018
 * &#64;author Amit Kshirsagar
 * &#64;version 1.0
 * &#64;since
 * 
 * <p><b>Modification History:</b><p>
 * 
 * 
 * </pre>
 */

@RepositoryRestResource
public interface AuthorityRepository extends CrudRepository<AuthorityEntity, Integer> {

}
