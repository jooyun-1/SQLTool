package com.sinsiway.intern.model.service.DBInfo;

import java.sql.Connection;
import java.util.LinkedHashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.sinsiway.intern.domain.SW_Connection_Log;
import com.sinsiway.intern.domain.SW_Database;

public interface DBInfoService {
	
	public List selectAll();
	public LinkedHashMap<String,Connection> selectOne(HttpServletRequest request, SW_Database db_info, SW_Connection_Log connLog);
	public void regist(SW_Database db_info);
	public void update(SW_Database db_info);
	public void delete(SW_Database db_info);
}
