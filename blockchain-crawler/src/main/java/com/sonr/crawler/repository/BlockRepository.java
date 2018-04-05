package com.sonr.crawler.repository;

import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import com.sonr.crawler.model.Block;

@RepositoryRestResource(collectionResourceRel = "contains", itemResourceRel = "contains", path = "contains")
public interface BlockRepository extends Neo4jRepository<Block, Long> {

}
