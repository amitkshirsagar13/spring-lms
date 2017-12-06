package io.lms.hibernate.aop;

import java.util.Date;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import io.lms.logging.BaseLogger;
import io.lms.model.BaseEntity;

/**
 * <p>
 * <b>Overview:</b>
 * <p>
 * 
 * 
 * <pre>
 * &#64;projectName DatasyncMicroService
 * &#64;class MongoRepositoryInterception
 * Creation date: Jan 30, 2017
 * &#64;author Amit Kshirsagar
 * &#64;version 1.0
 * &#64;since
 * 
 * <p><b>Modification History:</b><p>
 * 
 * 
 * </pre>
 */
@Aspect
@Component
public class MongoRepositoryInterceptor extends BaseLogger {

	private void logJoinPoints(JoinPoint joinPoint) {
		logInfo("AopAdvice => executed Before advice" + joinPoint.getTarget().getClass().getName() + ":"
				+ joinPoint.getSignature().getName());
	}

	@Before("execution(* io.lms.hibernate.repository.*.save*(..))")
	public void beforeSave(JoinPoint joinPoint) {
		logJoinPoints(joinPoint);
		if (joinPoint != null && joinPoint.getArgs() != null) {
			((BaseEntity) joinPoint.getArgs()[0]).setCreatedDate(new Date());
		}
	}

	@Before("execution(* io.lms.hibernate.repository.*.update*(..))")
	public void beforeUpdate(JoinPoint joinPoint) {
		logJoinPoints(joinPoint);
		if (joinPoint != null && joinPoint.getArgs() != null) {
			((BaseEntity) joinPoint.getArgs()[0]).setUpdatedDate(new Date());
		}
	}

	@Before("execution(* io.lms.hibernate.repository.*.mark*(..))")
	public void beforeStatusEntity(JoinPoint joinPoint) {
		logJoinPoints(joinPoint);
		if (joinPoint != null && joinPoint.getArgs() != null) {
			// ((BaseEntity) ((Exchange)
			// joinPoint.getArgs()[0]).getIn().getBody()).setUpdatedDate(new Date());
		}
	}

	@Before("execution(* io.lms.hibernate.repository.*.delete*(..))")
	public void beforeDelete(JoinPoint joinPoint) {
		logJoinPoints(joinPoint);
		if (joinPoint != null && joinPoint.getArgs() != null) {
			((BaseEntity) joinPoint.getArgs()[0]).setUpdatedDate(new Date());
			((BaseEntity) joinPoint.getArgs()[0]).setDeleted(true);
		}
	}
}
