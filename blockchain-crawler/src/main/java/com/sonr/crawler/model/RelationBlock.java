package com.sonr.crawler.model;

import java.util.HashSet;
import java.util.Set;

import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

@NodeEntity
public class RelationBlock {
	@Id
	@GeneratedValue
	Long id;
	String title;

	@Relationship(type = "ACTS_IN", direction = Relationship.INCOMING)
	Set<TestBlock> testBlocks = new HashSet<>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Set<TestBlock> getTestBlocks() {
		return testBlocks;
	}

	public void setTestBlocks(TestBlock testBlocks) {
		this.testBlocks.add(testBlocks);
	}
	

}
