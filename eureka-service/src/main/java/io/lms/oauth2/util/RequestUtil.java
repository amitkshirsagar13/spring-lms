package io.lms.oauth2.util;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.web.savedrequest.SavedRequest;

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

public class RequestUtil {
	private static final String XMLHTTPREQUEST = "XMLHttpRequest";
	private static final String XREQUESTEDWITH = "X-Requested-With";

	private static final String CONTENTTYPE = "Content-type";
	private static final String CONTENTTYPEJSON = "application/json";

	public static boolean isAjax(HttpServletRequest request) {
		return XMLHTTPREQUEST.equals(request.getHeader(XREQUESTEDWITH));
	}

	public static boolean isAjax(SavedRequest request) {
		return request.getHeaderValues(XREQUESTEDWITH).contains(XMLHTTPREQUEST);
	}

	public static boolean isContentTypeJson(SavedRequest request) {
		return request.getHeaderValues(CONTENTTYPE).contains(CONTENTTYPEJSON);
	}
}
