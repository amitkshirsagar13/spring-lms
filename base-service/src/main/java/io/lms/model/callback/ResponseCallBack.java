package io.lms.model.callback;

import com.google.common.util.concurrent.FutureCallback;

import io.lms.logging.BaseLogger;
import io.lms.model.Response;

/**
 * <p>
 * <b>Overview:</b>
 * <p>
 * 
 * 
 * <pre>
 * &#64;projectName DatasyncMicroService
 * &#64;class ResponseCallBack
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

public class ResponseCallBack extends BaseLogger implements FutureCallback<Response> {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.google.common.util.concurrent.FutureCallback#onSuccess(java.lang.
	 * Object)
	 */
	@Override
	public void onSuccess(Response result) {
		logInfo("Processed Callback Response for:" + result.toStringNoPretty());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.google.common.util.concurrent.FutureCallback#onFailure(java.lang.
	 * Throwable)
	 */
	@Override
	public void onFailure(Throwable t) {
		logError(t.getMessage());
	}

}
