package io.lms.security;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.GenericFilterBean;

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
public class SwaggerRequestFilter extends GenericFilterBean {

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
	// @Override
	// protected void doFilterInternal(HttpServletRequest request,
	// HttpServletResponse response, FilterChain filterChain)
	// throws ServletException, IOException {
	// request.getHeaderNames();
	// if (request.getHeader("origin") != null &&
	// request.getHeader("origin").contains(":9999")) {
	// Enumeration<String> headerNames = request.getHeaderNames();
	// while (headerNames.hasMoreElements()) {
	// String key = headerNames.nextElement();
	// String value = request.getHeader(key);
	// log4j.info(key + ": " + value);
	// }
	//
	// log4j.info(request.getRequestURI().toString());
	// log4j.info(request.getRequestURI().toString().substring(request.getRequestURI().toString().indexOf("/",
	// 1),
	// request.getRequestURI().toString().length()) + "?" +
	// request.getQueryString());
	//
	// HeaderMapRequestWrapper requestWrapper = new
	// HeaderMapRequestWrapper(request);
	//
	// requestWrapper.addHeader("Access-Control-Allow-Origin", "*");
	// requestWrapper.addHeader("Access-Control-Allow-Methods", "GET, POST, PUT,
	// DELETE");
	// requestWrapper.addHeader("Access-Control-Allow-Headers", "origin,
	// content-type, accept, x-requested-with");
	// requestWrapper.addHeader("Access-Control-Max-Age", "3600");
	//
	// response.addHeader("Access-Control-Allow-Origin", "*");
	// response.addHeader("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE");
	// response.addHeader("Access-Control-Allow-Headers", "origin, content-type,
	// accept, x-requested-with");
	// response.addHeader("Access-Control-Max-Age", "3600");
	//
	// request.getRequestDispatcher(
	// request.getRequestURI().toString().substring(request.getRequestURI().toString().indexOf("/",
	// 1),
	// request.getRequestURI().toString().length()) + "?" +
	// request.getQueryString())
	// .forward(requestWrapper, response);
	// } else {
	// filterChain.doFilter(request, response);
	// }
	// }

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.servlet.Filter#doFilter(javax.servlet.ServletRequest,
	 * javax.servlet.ServletResponse, javax.servlet.FilterChain)
	 */
	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain filterChain)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) resp;
		request.getHeaderNames();
		if (request.getHeader("origin") != null && request.getHeader("origin").contains(":9999")) {
			Enumeration<String> headerNames = request.getHeaderNames();
			while (headerNames.hasMoreElements()) {
				String key = headerNames.nextElement();
				String value = request.getHeader(key);
				// log4j.info(key + ": " + value);
			}

			log4j.info(request.getRequestURI().toString());
			String redirectUri = request.getRequestURI().toString().substring(
					request.getRequestURI().toString().indexOf("/", 1), request.getRequestURI().toString().length())
					+ "?" + request.getQueryString();
			log4j.info(redirectUri);

			HeaderMapRequestWrapper requestWrapper = new HeaderMapRequestWrapper(request);

			requestWrapper.addHeader("Access-Control-Allow-Origin", "*");
			requestWrapper.addHeader("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE");
			requestWrapper.addHeader("Access-Control-Allow-Headers", "origin, content-type, accept, x-requested-with");
			requestWrapper.addHeader("Access-Control-Max-Age", "3600");

			response.addHeader("Access-Control-Allow-Origin", "*");
			response.addHeader("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE");
			response.addHeader("Access-Control-Allow-Headers", "origin, content-type, accept, x-requested-with");
			response.addHeader("Access-Control-Max-Age", "3600");
			if (redirectUri.startsWith("/api")) {
				log4j.info("Redirecting URL: " + redirectUri);
				// response.sendRedirect(redirectUri);
				request.getRequestDispatcher(redirectUri).forward(requestWrapper, response);
			} else {
				return;
			}
		} else {
			filterChain.doFilter(request, response);
		}

	}

}
