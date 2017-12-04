package io.lms.controller;

import io.lms.logging.BaseLogger;
import io.lms.utils.BaseSystemUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
	@RequestMapping("/")
	public String home() {
		logInfo("Home Called....");
		String response = "";

		logInfo("Home Processed....");

		return "Hello Docker World: " + response;
	}
}
