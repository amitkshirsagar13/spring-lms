package io.lms.jms;

/**
 * <p>
 * <b>Overview:</b>
 * <p>
 * 
 * 
 * <pre>
 * &#64;projectName DatasyncMicroService
 * &#64;class ActiveMessageQueues
 * Creation date: Dec 31, 2016
 * &#64;author Amit Kshirsagar
 * &#64;version 1.0
 * &#64;since
 * 
 * <p><b>Modification History:</b><p>
 * 
 * 
 * </pre>
 */

public interface ActiveMessageQueues {

	String JMSLISTENERCONTAINERFACTORY = "jmsListenerContainerFactory";

	String KINESIS_QUEUE = "KINESIS_QUEUE";
	String TRANSFORM_QUEUE = "TRANSFORM_QUEUE";
	String IDENTITY_QUEUE = "IDENTITY_QUEUE";
	String WORKORDER_QUEUE = "WORKORDER_QUEUE";
}
