package com.sinsiway.intern.model.service.ExecuteLog;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.LinkedHashMap;

import javax.servlet.http.HttpServletRequest;

import org.json.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sinsiway.intern.Util.UtilMethod;
import com.sinsiway.intern.domain.SW_Execute_Log;
import com.sinsiway.intern.model.repository.ExecuteLog.ExecuteLogDAO;

@Service
public class ExecuteLogServiceImpl implements ExecuteLogService{
	@Autowired
	private ExecuteLogDAO executeLogDAO;
	private UtilMethod utilMethod = new UtilMethod();
	
	@Override
	public String regist(HttpServletRequest request, SW_Execute_Log exec_log, LinkedHashMap<String, Connection> conMap) throws ParseException {
		
		JSONObject db = utilMethod.decodeToken(conMap);
		int database_id = Integer.parseInt(String.valueOf(db.get("database_id")));
		exec_log.setDatabase_id(database_id);
		exec_log.setClient_ip(utilMethod.getIp(request));
		executeLogDAO.regist(exec_log);
		
		String sql = executeLogDAO.selectSql(exec_log);
		String sql_type = sql.split(" ")[0];		
		exec_log.setSql_type(sql_type);
		
		boolean result = true;
		String message = null;
		JSONArray jarr = new JSONArray();
		int res = 0;
		String conKey = (String) conMap.keySet().toArray()[conMap.size()-1];
	          try {
				PreparedStatement pstmt=(conMap.get(conKey)).prepareStatement(sql);
			     if(sql_type.equalsIgnoreCase("select")) {	        
		        	  ResultSet rs = pstmt.executeQuery();//쿼리 수행후 결과집합 가져오기.
		        	  while (rs.next()) {                 
		                  JSONObject obj = new JSONObject();
		                  ResultSetMetaData meta = rs.getMetaData();
		                  int total = meta.getColumnCount();
		                  for (int i=0; i<total; i++)
		                  {
		                      String name = meta.getColumnLabel(i+1);
		                      Object value = rs.getObject(i+1);
		                      obj.put(name, value);
		                      
		                  }
		                  jarr.put(obj);
		              }
		        	  message = "수행 성공";	 
		        	 
			     }else {
		        	  res = pstmt.executeUpdate();
		        	  System.out.println(res);
		        	  if(res>0) {
		        		  jarr.put(res+"건 완료했습니다");
		        		  message = res+"건 수행 성공";
		        	  }else {
		        		  jarr.put("완료");
		        		  message = "수행 성공";
		        	  }
		          }
			    
	         
			} catch (SQLException e) {
				message = "수행 실패";
				e.printStackTrace();
			}
		 exec_log.setResult(result);
		 exec_log.setMessage(message);
		 
		 return jarr.toString();
	}
	
	@Override
	public String selectSql(SW_Execute_Log exec_log) {
		
		return "";
	}
	
	@Override
	public void update(SW_Execute_Log exec_log) {
		executeLogDAO.update(exec_log);
		
	}
	
	@Override
	public void delete(int id) {
		executeLogDAO.delete(id);
		
	}


}
