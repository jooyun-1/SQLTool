package com.sinsiway.intern.model.repository.DBInfo;

import java.util.List;

import com.sinsiway.intern.domain.SW_Database;

public interface DBInfoDAO {
	public List selectAll();
	public SW_Database selectOne(int database_id);
	public void regist(SW_Database db_info);
	public void update(SW_Database db_info);
	public void delete(SW_Database db_info);
}


