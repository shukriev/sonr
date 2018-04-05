package com.sonr.crawler.model;

import java.util.HashSet;
import java.util.Set;

import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.Index;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

@NodeEntity
public class Account {

//	@Id
//	@GeneratedValue
//	private Long id;
	
	@Id
    @Index(unique = true)
	private String address_hash;

	@Relationship(type = "CONTAINS", direction = Relationship.OUTGOING)
	private Set<Block> sendsBlock = new HashSet<>();

	@Relationship(type = "CONTAINS", direction = Relationship.INCOMING)
	private Set<Block> receiveBlock = new HashSet<>();
	    
	public Account() {
		super();
	}
	
	public Account(String address_hash) {
		super();
		this.address_hash = address_hash;
	}

	
//	public Long getId() {
//		return id;
//	}
//
//	public void setId(Long id) {
//		this.id = id;
//	}

	public String getAddress_hash() {
		return address_hash;
	}

	public void setAddress_hash(String address_hash) {
		this.address_hash = address_hash;
	}

	public Set<Block> getSendsBlock() {
		return sendsBlock;
	}

	public void setSendsBlock(Block sendsBlock) {
		this.sendsBlock.add(sendsBlock);
	}

	public Set<Block> getReceiveBlock() {
		return receiveBlock;
	}

	public void setReceiveBlock(Block receiveBlock) {
		this.receiveBlock.add(receiveBlock);
	}

	@Override
	public String toString() {
		return "Account [address_hash=" + address_hash + ", sendsBlock=" + sendsBlock + ", receiveBlock=" + receiveBlock
				+ "]";
	}
	
	
}
