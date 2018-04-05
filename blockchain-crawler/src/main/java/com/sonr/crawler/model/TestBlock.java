package com.sonr.crawler.model;

import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;

@NodeEntity
public class TestBlock {

	@Id
	@GeneratedValue
	Long id;
	String title;
}
