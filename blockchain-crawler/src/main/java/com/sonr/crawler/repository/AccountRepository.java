package com.sonr.crawler.repository;

import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

import com.sonr.crawler.model.Account;

@Repository
public interface AccountRepository extends Neo4jRepository<Account, Long> {

}
