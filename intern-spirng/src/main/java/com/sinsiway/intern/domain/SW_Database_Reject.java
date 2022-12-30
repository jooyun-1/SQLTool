package com.sinsiway.intern.domain;

import lombok.Data;


//접속 차단 테이블
public class SW_Database_Reject {
	private int policy_id;
	private int database_id; //foreign key
	private String client_ip;//차단 ip
	
	public int getPolicy_id() {
		return policy_id;
	}
	public void setPolicy_id(int policy_id) {
		this.policy_id = policy_id;
	}
	public int getDatabase_id() {
		return database_id;
	}
	public void setDatabase_id(int database_id) {
		this.database_id = database_id;
	}
	public String getClient_ip() {
		return client_ip;
	}
	public void setClient_ip(String client_ip) {
		this.client_ip = client_ip;
	}
	
}
