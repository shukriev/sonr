package com.sonr.crawler.repository;

import org.springframework.data.neo4j.repository.Neo4jRepository;

import com.sonr.crawler.model.RelationBlock;

public interface RelationBlockRepository extends Neo4jRepository<RelationBlock, Long>{

}
