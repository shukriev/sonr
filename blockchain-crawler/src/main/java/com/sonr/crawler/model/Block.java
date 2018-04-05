package com.sonr.crawler.model;

import java.io.Serializable;

import org.neo4j.ogm.annotation.EndNode;
import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.Index;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;
import org.neo4j.ogm.annotation.RelationshipEntity;
import org.neo4j.ogm.annotation.StartNode;

@NodeEntity
public class Block {
	
//	@Id
//	@GeneratedValue
//	private Long id;
    
	@Id
	@Index(unique = true)
	private String blockNumber;
	
	private String timeStamp;
	private String hash;
	private int nonce;
	private String blockHash;
	private int transactionIndex;
	
	//Theirs
//	@EndNode
//	@Relationship(type = "FROM", direction = Relationship.INCOMING)
	private Account from;
	
	//Mine
//	@StartNode
//	@Relationship(type = "TO", direction = Relationship.INCOMING)
	private Account to;
	
	private String value;
	private Long gas;
	private Double gasPrice;
	private boolean isError;
	private String txreceipt_status;
	private String input;
	private String contractAddress;
	private Long cumulativeGasUsed;
	private Long confirmations;
	
	public Block() {
		super();
	}
	
	public Block(String blockNumber, String timeStamp, String hash, int nonce, String blockHash, int transactionIndex,
			Account from, Account to, String value, Long gas, Double gasPrice, boolean isError, String txreceipt_status,
			String input, String contractAddress, Long cumulativeGasUsed, Long confirmations) {
		super();
		this.blockNumber = blockNumber;
		this.timeStamp = timeStamp;
		this.hash = hash;
		this.nonce = nonce;
		this.blockHash = blockHash;
		this.transactionIndex = transactionIndex;
		this.from = from;
		this.to = to;
		this.value = value;
		this.gas = gas;
		this.gasPrice = gasPrice;
		this.isError = isError;
		this.txreceipt_status = txreceipt_status;
		this.input = input;
		this.contractAddress = contractAddress;
		this.cumulativeGasUsed = cumulativeGasUsed;
		this.confirmations = confirmations;
	}
	
	
	public void setFrom(Account from) {
		this.from = from;
	}

	public String getBlockNumber() {
		return blockNumber;
	}
	public void setBlockNumber(String blockNumber) {
		this.blockNumber = blockNumber;
	}
	
	public String getTimeStamp() {
		return timeStamp;
	}
	public void setTimeStamp(String timeStamp) {
		this.timeStamp = timeStamp;
	}
	
	public String getHash() {
		return hash;
	}
	public void setHash(String hash) {
		this.hash = hash;
	}
	
	public int getNonce() {
		return nonce;
	}
	public void setNonce(int nonce) {
		this.nonce = nonce;
	}
	
	public String getBlockHash() {
		return blockHash;
	}
	public void setBlockHash(String blockHash) {
		this.blockHash = blockHash;
	}
	
	public int getTransactionIndex() {
		return transactionIndex;
	}
	public void setTransactionIndex(int transactionIndex) {
		this.transactionIndex = transactionIndex;
	}
	
	public Account getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = new Account(from);
	}
	
	public Account getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = new Account(to);
	}
	
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	
	public Long getGas() {
		return gas;
	}
	public void setGas(Long gas) {
		this.gas = gas;
	}
	
	public Double getGasPrice() {
		return gasPrice;
	}
	public void setGasPrice(Double gasPrice) {
		this.gasPrice = gasPrice;
	}
	
	public boolean isError() {
		return isError;
	}
	public void setError(int isError) {
		this.isError = isError == 0 ? true : false;
	}
	
	public String getTxreceipt_status() {
		return txreceipt_status;
	}
	public void setTxreceipt_status(String txreceipt_status) {
		this.txreceipt_status = txreceipt_status;
	}
	
	public String getInput() {
		return input;
	}
	public void setInput(String input) {
		this.input = input;
	}
	
	public String getContractAddress() {
		return contractAddress;
	}
	public void setContractAddress(String contractAddress) {
		this.contractAddress = contractAddress;
	}
	
	public Long getCumulativeGasUsed() {
		return cumulativeGasUsed;
	}
	public void setCumulativeGasUsed(Long cumulativeGasUsed) {
		this.cumulativeGasUsed = cumulativeGasUsed;
	}
	
	public Long getConfirmations() {
		return confirmations;
	}
	public void setConfirmations(Long confirmations) {
		this.confirmations = confirmations;
	}
}
