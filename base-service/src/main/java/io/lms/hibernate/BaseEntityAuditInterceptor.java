package io.lms.hibernate;

import java.io.Serializable;
import java.util.Date;

import org.apache.log4j.Logger;
import org.hibernate.CallbackException;
import org.hibernate.EmptyInterceptor;
import org.hibernate.type.Type;

import io.swagger.annotations.ApiModelProperty;

/**
 * 
 * <p>
 * <b>Overview:</b>
 * <p>
 * 
 * 
 * <pre>
 * &#64;projectName DatasyncMicroService
 * &#64;class BaseEntityAuditInterceptor
 * Creation date: Jan 24, 2017
 * &#64;author Amit Kshirsagar
 * &#64;version 1.0
 * &#64;since
 * 
 * <p><b>Modification History:</b><p>
 * 
 * 
 * </pre>
 */

public class BaseEntityAuditInterceptor extends EmptyInterceptor {

	@ApiModelProperty(required = false, hidden = true)
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

	/**
	 * The Serial Version UUID.
	 */
	private static final long serialVersionUID = 4636626262147801287L;

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.hibernate.EmptyInterceptor#onSave(java.lang.Object,
	 * java.io.Serializable, java.lang.Object[], java.lang.String[],
	 * org.hibernate.type.Type[])
	 */
	@Override
	public boolean onSave(Object entity, Serializable id, Object[] state, String[] propertyNames, Type[] types) {
		logInfo("onSave");
		if (entity instanceof PersistModifiable) {
			PersistModifiable record = (PersistModifiable) entity;
			record.setCreatedDate(new Date());
			for (int i = 0; i < propertyNames.length; i++) {
				if ("createdDate".equals(propertyNames[i]))
					state[i] = new Date();
			}
		}
		return false;
	}

	@Override
	public boolean onFlushDirty(Object entity, Serializable id, Object[] currentState, Object[] previousState,
			String[] propertyNames, Type[] types) throws CallbackException {
		logInfo("onFlushDirty");
		if (entity instanceof PersistModifiable) {
			PersistModifiable record = (PersistModifiable) entity;
			record.setUpdatedDate(new Date());
			for (int i = 0; i < propertyNames.length; i++) {
				if ("updatedDate".equals(propertyNames[i]))
					currentState[i] = new Date();
			}
		}
		return false;

	}

	@Override
	public void onDelete(Object entity, Serializable id, Object[] state, String[] propertyNames, Type[] types) {
		logInfo("onDelete");
		if (entity instanceof PersistModifiable) {
			PersistModifiable record = (PersistModifiable) entity;
			record.setDeleted(true);
			record.setUpdatedDate(new Date());
		}
	}
}
