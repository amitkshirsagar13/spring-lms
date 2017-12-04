package io.lms.jms.queue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;

import io.lms.jms.ActiveMessageQueues;
import io.lms.logging.BaseLogger;
import io.lms.utils.ObjectSerializer;

/**
 * 
 * <p>
 * <b>Overview:</b>
 * <p>
 * 
 * 
 * <pre>
 * &#64;projectName DatasyncMicroService
 * &#64;class BaseJmsListener
 * Creation date: Dec 30, 2016
 * &#64;author Amit Kshirsagar
 * &#64;version 1.0
 * &#64;since
 * 
 * <p><b>Modification History:</b><p>
 * 
 * 
 * </pre>
 */

@ComponentScan({ "io.lms.utils" })
public class BaseJmsService extends BaseLogger implements ActiveMessageQueues {
	@Autowired
	public ObjectSerializer objectSerializer;

}
