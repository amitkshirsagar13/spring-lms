package io.lms.oauth2.config;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.AuthenticationEntryPoint;
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
	public void configure(final WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/resources/**");
	}

	@Override
	public void configure(HttpSecurity http) throws Exception {
		http.requestMatchers().antMatchers("/**").and().exceptionHandling()
				.accessDeniedPage("/login?authorization_error=true").and().authorizeRequests()
				.antMatchers("/resources/**", "/csrf", "/assets/**", "/error", "/admin/**").permitAll().anyRequest()
				.authenticated().and().requestMatchers().antMatchers("/admin/**").and().authorizeRequests()
				.antMatchers("/admin/**").hasRole("ACTUATOR").anyRequest().authenticated().and().httpBasic().and()
				.formLogin().loginPage("/login").usernameParameter("form-username").passwordParameter("form-password")
				.loginProcessingUrl("/login.do").permitAll().and().logout()
				.logoutRequestMatcher(new AntPathRequestMatcher("/logout.do")).and().logout().logoutSuccessUrl("/login")
				.permitAll().and().requestMatchers()
				.antMatchers("/login", "/login.do", "/oauth/authorize", "/oauth/confirm_access").and()
				.userDetailsService(userDetailsService());
		AuthenticationEntryPoint aep = new AuthenticationEntryPoint() {
			@Override
			public void commence(HttpServletRequest request, HttpServletResponse response,
					AuthenticationException authException) throws IOException, ServletException {
				response.sendRedirect("/login");
			}
		};

		http.exceptionHandling().authenticationEntryPoint(aep);
	}
}