/**
 * 
 */
package io.lms.oauth2.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

@Service
public class AuthorityService {

	@Autowired
	private AuthorityRepository authorityRepository;

	public void saveAuthority(AuthorityEntity role) {
		authorityRepository.save(role);
	}

	public List<AuthorityEntity> getAllAuthorities() {
		List<AuthorityEntity> authorities = new ArrayList<>();
		for (AuthorityEntity authority : authorityRepository.findAll()) {
			authorities.add(authority);
		}
		return authorities;
	}
}
