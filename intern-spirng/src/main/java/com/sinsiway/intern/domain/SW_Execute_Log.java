package com.sinsiway.intern.domain;



import java.util.Date;

import lombok.Data;


public class SW_Execute_Log {
	private int id;
	private int database_id;
	private String client_ip;
	private Date exec_date = new Date(); //수행 일시
	private String sql_text;//쿼리 문장
	private String sql_type;//수행 타입
	
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
	public Date getExec_date() {
		return exec_date;
	}
	public void setExec_date(Date exec_date) {
		this.exec_date = exec_date;
	}
	public String getSql_text() {
		return sql_text;
	}
	public void setSql_text(String sql_text) {
		this.sql_text = sql_text;
	}
	public String getSql_type() {
		return sql_type;
	}
	public void setSql_type(String sql_type) {
		this.sql_type = sql_type;
	}
	public boolean isResult() {
		return result;
	}
	public void setResult(boolean result) {
		this.result = result;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	private boolean result; //수행 결과
	private String message;//수행 메시지
}
