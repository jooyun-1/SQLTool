package com.sinsiway.intern.model.service.ExecuteLog;

import java.sql.Connection;
import java.util.LinkedHashMap;

import javax.servlet.http.HttpServletRequest;

import org.json.simple.JSONArray;
import org.json.simple.parser.ParseException;

import com.sinsiway.intern.domain.SW_Execute_Log;


public interface ExecuteLogService {
	public String regist(HttpServletRequest request, SW_Execute_Log exec_log, LinkedHashMap<String,Connection> conMap) throws ParseException;
	public String selectSql(SW_Execute_Log exec_log);
	public void update(SW_Execute_Log exec_log);
	public void delete(int id);
}
