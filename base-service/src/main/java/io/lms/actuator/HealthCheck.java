package io.lms.actuator;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.Health.Builder;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

/**
 * <p>
 * <b>Overview:</b>
 * <p>
 * 
 * 
 * <pre>
 * &#64;projectName DatasyncMicroService
 * &#64;class HealthCheck
 * Creation date: Jan 31, 2017
 * &#64;author Amit Kshirsagar
 * &#64;version 1.0
 * &#64;since
 * 
 * <p><b>Modification History:</b><p>
 * 
 * 
 * </pre>
 */

@Component
public class HealthCheck implements HealthIndicator {
	@Override
	public Health health() {
		return check().build();
	}

	public Builder check() {
		int errorCode = 0;
		if (errorCode != 0) {
			return Health.down().withDetail("Error Code", errorCode);
		}

		return Health.up().withDetail("everything", "Stright....").withDetail("something", "Working....")
				.withDetail("nothing", "Wrong....");
	}
}
