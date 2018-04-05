package com.sonr.crawler.config;

import org.neo4j.ogm.session.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;
import org.springframework.data.neo4j.transaction.Neo4jTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableNeo4jRepositories(basePackages = "com.sonr.crawler.repository")
@EnableTransactionManagement
@ComponentScan("org.neo4j.cineasts")
public class GraphConfiguration {
	@Bean
	public SessionFactory sessionFactory() {
		// with domain entity base package(s)
		return new SessionFactory(config(), "com.sonr.crawler.model");
	}

	@Bean
	public Neo4jTransactionManager transactionManager() {
		return new Neo4jTransactionManager(sessionFactory());
	}

	public org.neo4j.ogm.config.Configuration config() {
		return new org.neo4j.ogm.config.Configuration.Builder().uri("bolt://localhost:7687")
				.credentials("neo4j", "123456").build();
	}
	
	// @Bean
	// @Override
	// public Neo4jServer neo4jServer() {
	// return new RemoteServer("bolt://localhost:7687", "neo4j", "123456");
	//
	// }
}
