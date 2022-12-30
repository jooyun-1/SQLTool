package com.sinsiway.intern.domain;



import java.util.Date;

import lombok.Data;

//접속 로그 테이블
public class SW_Connection_Log {
	private int id;
	private int database_id;//foreign key
	private String client_ip;
	private Date connect_date = new Date();//접속 일시
	private boolean result;//접속 결과
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public Date getConnect_date() {
		return connect_date;
	}
	public void setConnect_date(Date connect_date) {
		this.connect_date = connect_date;
	}
	public boolean isResult() {
		return result;
	}
	public void setResult(boolean result) {
		this.result = result;
	}

}
