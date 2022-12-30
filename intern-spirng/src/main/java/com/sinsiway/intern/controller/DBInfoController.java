package com.sinsiway.intern.controller;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sinsiway.intern.Util.UtilMethod;
import com.sinsiway.intern.domain.SW_Connection_Log;
import com.sinsiway.intern.domain.SW_Database;
import com.sinsiway.intern.domain.SW_Database_Reject;
import com.sinsiway.intern.domain.SW_Execute_Log;
import com.sinsiway.intern.model.service.ConnectionLog.ConnLogService;
import com.sinsiway.intern.model.service.DBInfo.DBInfoService;
import com.sinsiway.intern.model.service.DBReject.DBRejectService;
import com.sinsiway.intern.model.service.ExecuteLog.ExecuteLogService;


@Controller
public class DBInfoController {
	
	@Autowired
	private DBInfoService dbinfoService;
	@Autowired
	private ConnLogService connLogService;
	@Autowired
	private ExecuteLogService execLogService;
	@Autowired
	private DBRejectService dbRejectService;
	
	UtilMethod utilMethod = new UtilMethod();
	
	@PostMapping("/databases") //데이터베이스 추가
	public @ResponseBody SW_Database addDatabase(@RequestBody SW_Database db_info) {
		dbinfoService.regist(db_info);
		return db_info;
	}
	
	@PutMapping("/databases/{id}") //데이터베이스 수정
	public @ResponseBody SW_Database editDatabase(@PathVariable("id") int database_id, @RequestBody SW_Database db_info) {
		dbinfoService.update(db_info);
		return db_info;
	}
	
	@DeleteMapping("/databases/{id}") //데이터베이스 제거
	public @ResponseBody String removeDatabase(@PathVariable("id") int database_id, @RequestBody SW_Database db_info) {		
		dbinfoService.delete(db_info);
		return utilMethod.getMessage("delete");
	}
	
	@GetMapping("/databases") //데이터베이스 내역
	public @ResponseBody List showDatabase() {
		return dbinfoService.selectAll();	
	}
	
	LinkedHashMap<String,Connection> conMap = new LinkedHashMap<>();
	
	@PostMapping("/connect") //접속
	public @ResponseBody String ConnDataBase(HttpServletRequest request,@RequestBody SW_Database db_info,SW_Connection_Log connLog) {		
		conMap = dbinfoService.selectOne(request, db_info, connLog);		
		JSONArray conArr = new JSONArray();
		String conKey = (String) conMap.keySet().toArray()[conMap.size()-1];
		if(conKey.equals("message")) {
			conMap.remove(conKey);
			connLogService.regist(connLog);
			return utilMethod.getMessage("reject");			
		}else {			
		    for(String key : conMap.keySet()) {
		    	JSONObject conMapObj = new JSONObject();
		    	conMapObj.put("tokenID", key);
		    	conArr.add(conMapObj);		    	
		    }
		}
	    connLogService.regist(connLog);
	    return conArr.toString();
	}	

	@PostMapping("/disconnect") //접속 종료
	public @ResponseBody String DisConnDataBase(HttpServletRequest request, @RequestBody HashMap<String,String> map) {
		ArrayList<String> removeConList = new ArrayList<>();
		try {
			for(String key : conMap.keySet()) {
				if(key.equals(map.get("tokenID"))) {
					(conMap.get(key)).close();
					removeConList.add(key);
				}
			}
			for(String remove : removeConList) {
				conMap.remove(remove);
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}	
		return utilMethod.getMessage("exit");
	}	

	@PostMapping("/run") //쿼리 실행
	public @ResponseBody String execQuery(HttpServletRequest request,@RequestBody SW_Execute_Log execLog) throws ParseException {
		String result = execLogService.regist(request,execLog,conMap);
	    execLogService.update(execLog);
	    return result;
	}
	
	@PostMapping("/reject") //차단 IP 추가
	public @ResponseBody SW_Database_Reject addRejectIp(@RequestBody SW_Database_Reject db_reject) {
		dbRejectService.insert(db_reject);
		return db_reject;
	}
	
	@DeleteMapping("/reject/{policy_id}") //차단 IP 제거
	public @ResponseBody String removeRejectIp(@PathVariable("policy_id") int policy_id, @RequestBody SW_Database_Reject db_reject) {
		dbRejectService.delete(db_reject);
		return utilMethod.getMessage("delete");
	}
	
}
