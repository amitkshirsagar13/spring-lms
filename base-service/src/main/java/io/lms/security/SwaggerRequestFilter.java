package io.lms.security;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

/**
 * <p>
 * <b>Overview:</b>
 * <p>
 * 
 * 
 * <pre>
 * &#64;projectName base-service
 * Creation date: Dec 7, 2017
 * &#64;author Amit Kshirsagar
 * &#64;version 1.0
 * &#64;since
 * 
 * <p><b>Modification History:</b><p>
 * 
 * 
 * </pre>
 */
@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
public class SwaggerRequestFilter extends OncePerRequestFilter {

	/**
	 * log4j object for debugging.
	 */
	private static Logger log4j = Logger.getLogger(SwaggerRequestFilter.class);

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.springframework.web.filter.OncePerRequestFilter#doFilterInternal(javax.
	 * servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse,
	 * javax.servlet.FilterChain)
	 */
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		request.getHeaderNames();
		if (request.getHeader("origin") != null && request.getHeader("origin").contains(":9999")) {
			Enumeration<String> headerNames = request.getHeaderNames();
			while (headerNames.hasMoreElements()) {
				String key = headerNames.nextElement();
				String value = request.getHeader(key);
				log4j.info(key + ": " + value);
			}

			log4j.info(request.getRequestURI().toString());
			log4j.info(request.getRequestURI().toString().substring(request.getRequestURI().toString().indexOf("/", 1),
					request.getRequestURI().toString().length()) + "?" + request.getQueryString());

			response.addHeader("Access-Control-Allow-Origin", "*");
			response.addHeader("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS");
			response.addHeader("Access-Control-Allow-Headers", "origin, content-type, accept, x-requested-with");
			response.addHeader("Access-Control-Max-Age", "3600");

			request.getRequestDispatcher(
					request.getRequestURI().toString().substring(request.getRequestURI().toString().indexOf("/", 1),
							request.getRequestURI().toString().length()) + "?" + request.getQueryString())
					.forward(request, response);
		} else {
			filterChain.doFilter(request, response);
		}
	}

}
