package io.lms.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import io.lms.logging.BaseLogger;

/**
 * <p>
 * <b>Overview:</b>
 * <p>
 * 
 * 
 * <pre>
 * &#64;projectName DatasyncMicroService
 * &#64;class BaseController
 * Creation date: Feb 2, 2017
 * &#64;author Amit Kshirsagar
 * &#64;version 1.0
 * &#64;since
 * 
 * <p><b>Modification History:</b><p>
 * 
 * 
 * </pre>
 */

@RestController
public class BaseController extends BaseLogger {

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView home() {
		return new ModelAndView("redirect:" + "/swagger-ui.html");
	}

	// @RequestMapping(value = "/api/**", method = RequestMethod.OPTIONS)
	// public void corsHeaders(HttpServletResponse response) {
	// response.addHeader("Access-Control-Allow-Origin", "*");
	// response.addHeader("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE,
	// OPTIONS");
	// response.addHeader("Access-Control-Allow-Headers", "origin, content-type,
	// accept, x-requested-with");
	// response.addHeader("Access-Control-Max-Age", "3600");
	// }

}
