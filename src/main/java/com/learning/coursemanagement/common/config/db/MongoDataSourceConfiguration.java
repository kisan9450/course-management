package com.learning.coursemanagement.common.config.db;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.mongo.MongoProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.data.mongodb.config.AbstractMongoClientConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableMongoRepositories(basePackages = { "com.learning" })
public class MongoDataSourceConfiguration extends AbstractMongoClientConfiguration {

	private static final Logger LOG = LoggerFactory.getLogger(MongoDataSourceConfiguration.class);

	private MongoProperties mongoProperties;

	private Environment env;

	MongoDataSourceConfiguration(MongoProperties mongoProperties, Environment env) {
		this.mongoProperties = mongoProperties;
		this.env = env;
	}

	@Override
	protected String getDatabaseName() {
		return mongoProperties.getDatabase();
	}

}
