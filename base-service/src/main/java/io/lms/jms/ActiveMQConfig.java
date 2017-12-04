package io.lms.jms;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.connection.CachingConnectionFactory;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.support.destination.DestinationResolver;
import org.springframework.jms.support.destination.DynamicDestinationResolver;

import io.lms.logging.BaseLogger;

/**
 * 
 * <p>
 * <b>Overview:</b>
 * <p>
 * 
 * 
 * <pre>
 * &#64;projectName DatasyncMicroService
 * &#64;class ActiveMQConfig
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

@Configuration
@EnableConfigurationProperties
@EnableJms
public class ActiveMQConfig extends BaseLogger implements ActiveMessageQueues {
	@Autowired
	private Environment environment;

	@Bean
	public CachingConnectionFactory connectionFactory() {
		return new CachingConnectionFactory(amqConnectionFactory());
	}

	@Bean
	public DestinationResolver destinationResolver() {
		return new DynamicDestinationResolver();
	}

	@Bean
	public DefaultJmsListenerContainerFactory jmsListenerContainerFactory() {
		DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
		factory.setConnectionFactory(amqConnectionFactory());
		factory.setDestinationResolver(destinationResolver());
		factory.setConcurrency("2-3");
		return factory;
	}

	@Bean
	public ActiveMQConnectionFactory amqConnectionFactory() {
		String url = "tcp://" + environment.getProperty("localmq.host") + ":" + environment.getProperty("localmq.port");
		return new ActiveMQConnectionFactory(url);
	}

	protected JmsTemplate initializeTemplate(ActiveMQQueue queue) {
		JmsTemplate template = new JmsTemplate();
		template.setConnectionFactory(amqConnectionFactory());
		template.setDefaultDestination(queue);
		return template;
	}

}
