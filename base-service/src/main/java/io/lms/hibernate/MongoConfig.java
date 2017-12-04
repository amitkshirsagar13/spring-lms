package io.lms.hibernate;

import java.net.UnknownHostException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.mongodb.MongoClient;

/**
 * <p>
 * <b>Overview:</b>
 * <p>
 * 
 * 
 * <pre>
 * &#64;projectName DatasyncMicroService
 * &#64;class MongoConfig
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
@Configuration
@EnableConfigurationProperties
@EnableTransactionManagement
@ComponentScan({ "io.lms.hibernate", "io.lms.hibernate.aop" })
public class MongoConfig {
	@Autowired
	private Environment environment;

	@Bean
	public MongoDbFactory mongoDbFactory() throws UnknownHostException {
		return new SimpleMongoDbFactory(
				new MongoClient(environment.getProperty("mongodb.host"),
						environment.getProperty("mongodb.port", Integer.class)),
				environment.getProperty("mongodb.database"));
	}

	@Bean
	public MongoOperations mongoOperations() throws UnknownHostException {
		return new MongoTemplate(mongoDbFactory());
	}
}
