package io.lms.oauth2.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import io.lms.oauth2.dao.UserDetailsDao;

/**
 * <p>
 * <b>Overview:</b>
 * <p>
 * 
 * 
 * <pre>
 * &#64;projectName eureka-service
 * Creation date: Dec 5, 2017
 * &#64;author Amit Kshirsagar
 * &#64;version 1.0
 * &#64;since
 * 
 * <p><b>Modification History:</b><p>
 * 
 * 
 * </pre>
 */

@EnableWebSecurity
@Configuration
@SuppressWarnings("unused")
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
	@Bean
	@Override
	protected UserDetailsService userDetailsService() {
		return new UserDetailsDao();
	}

	@Override
	public void configure(HttpSecurity http) throws Exception {
		http.formLogin().loginPage("/login").usernameParameter("form-username").passwordParameter("form-password")
				.loginProcessingUrl("/login.do").permitAll().and().authorizeRequests().antMatchers("/me")
				.authenticated().and().logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout.do")).and()
				.requestMatchers().antMatchers("/login", "/login.do", "/oauth/authorize", "/oauth/confirm_access").and()
				.authorizeRequests().anyRequest().authenticated().and().userDetailsService(userDetailsService());
	}
}