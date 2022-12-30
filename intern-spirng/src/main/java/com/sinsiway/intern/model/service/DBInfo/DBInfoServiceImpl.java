package com.sinsiway.intern.model.service.DBInfo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sinsiway.intern.Util.UtilMethod;
import com.sinsiway.intern.domain.SW_Connection_Log;
import com.sinsiway.intern.domain.SW_Database;
import com.sinsiway.intern.model.repository.DBInfo.DBInfoDAO;
import com.sinsiway.intern.model.repository.DBReject.DBRejectDAO;

@Service

public class DBInfoServiceImpl implements DBInfoService{
	
	@Autowired
	private DBInfoDAO dbInfoDAO;
	@Autowired
	private DBRejectDAO dbRejectDAO;
	
	private UtilMethod util = new UtilMethod();
	
	@Override
	public List selectAll() {
		
		return dbInfoDAO.selectAll();
	}

	@Override
	public void regist(SW_Database db_info) {
		dbInfoDAO.regist(db_info);
		
	}

	LinkedHashMap<String,Connection> conMap = new LinkedHashMap<>();
	
	@Override
	public LinkedHashMap<String,Connection> selectOne(HttpServletRequest request, SW_Database db_info, SW_Connection_Log connLog) {			
		SW_Database db = dbInfoDAO.selectOne(db_info.getDatabase_id());
	    String url = "jdbc:" + getDriverName(db)+ "://" + db.getIp() + "/" + db.getUsername();
	    String token = null;
	    boolean result = true;
	    String client_ip = util.getIp(request);
	    String reject_ip = dbRejectDAO.select(db_info.getDatabase_id());
		if(reject_ip != null && reject_ip.equals(util.getIp(request))) {
			result = false;
			conMap.put("message", null);
		}else {
	    	try {	     		
	    		Connection con = DriverManager.getConnection(url, db.getUsername(), db.getPassword());
	    		token = util.createToken(db);				
	    		conMap.put(token,con);	    		
	    	} catch (SQLException e) {
	    		result = false;
	    		e.printStackTrace();			
	    	}
		}
    	connLog.setDatabase_id(db_info.getDatabase_id());
    	connLog.setClient_ip(client_ip);
    	connLog.setResult(result);
    	return conMap;
	}
	
	@Override
	public void update(SW_Database db_info) {
		dbInfoDAO.update(db_info);
		
	}

	@Override
	public void delete(SW_Database db_info) {
		dbInfoDAO.delete(db_info);
		
	}
	
	public String getDriverName(SW_Database db_info) {
		switch (db_info.getType()) {
		case 1:
			return "mariadb";
		case 2:
			return "postgresql";
		default:
			return "";
		}
		
	}

	
}
