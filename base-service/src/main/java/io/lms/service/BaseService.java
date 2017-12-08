package io.lms.service;

import io.lms.logging.BaseLogger;
import io.lms.model.Response;

/**
 * <p>
 * <b>Overview:</b>
 * <p>
 * 
 * 
 * <pre>
 * &#64;projectName base-service
 * Creation date: Dec 8, 2017
 * &#64;author Amit Kshirsagar
 * &#64;version 1.0
 * &#64;since
 * 
 * <p><b>Modification History:</b><p>
 * 
 * 
 * </pre>
 */

public class BaseService extends BaseLogger {

	public Response alternateControllerMethod(String workOrder, Throwable e) {
		logError("Failing over alternateWebServiceMethod...." + e.getMessage());
		return (Response) new Response().setStatus("Mongodb not available...Failing over....").setStatus("failure");
	}

}
