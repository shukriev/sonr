package com.sonr.crawler.model;

import java.util.List;

public class BlocksResult {
	private byte status;
	private String message;
	private List<Block> result;
	
	public byte getStatus() {
		return status;
	}
	public void setStatus(byte status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public List<Block> getResult() {
		return this.result;
	}
	public void setResult(List<Block> result) {
		this.result = result;
	}
}
