package io.lms.logging;

import org.apache.log4j.Logger;

/**
 * <p>
 * <b>Overview:</b>
 * <p>
 * 
 * 
 * <pre>
 * &#64;projectName DatasyncMicroService
 * &#64;class BaseLogger
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

public class BaseLogger {

	//@ApiModelProperty(required = false, hidden = true)
	Logger logger = Logger.getLogger(this.getClass());

	public void logDebug(Object message) {
		if (logger.isDebugEnabled()) {
			logger.debug(message);
		}
	}

	public void logInfo(Object message) {
		if (logger.isInfoEnabled()) {
			logger.info(message);
		}
	}

	public void logTrace(Object message) {
		if (logger.isTraceEnabled()) {
			logger.trace(message);
		}
	}

	public void logError(Object message) {
		logger.error(message);
	}

	public void logError(Object message, Throwable t) {
		logger.error(message, t);
	}
}
