package io.lms.turbine.security;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * 
 * <p>
 * <b>Overview:</b>
 * <p>
 * 
 * 
 * <pre>
 * &#64;projectName zuul-service
 * &#64;class BaseZuulSecurityConfig
 * Creation date: Feb 13, 2017
 * &#64;author Amit Kshirsagar
 * &#64;version 1.0
 * &#64;since
 * 
 * <p><b>Modification History:</b><p>
 * 
 * 
 * </pre>
 */

@Configuration
@EnableWebSecurity
@EnableConfigurationProperties
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class BaseTurbineSecurityConfig extends WebSecurityConfigurerAdapter {
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable().httpBasic().disable();
	}

	@Override
	protected void configure(AuthenticationManagerBuilder authManagerBuilder) throws Exception {
	}

	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/");
		web.ignoring().antMatchers("/hystrix.stream");
		web.ignoring().antMatchers("/turbine.stream");
	}
}
