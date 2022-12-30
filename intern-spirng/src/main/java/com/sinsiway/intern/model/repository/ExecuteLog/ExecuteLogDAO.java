package com.sinsiway.intern.model.repository.ExecuteLog;

import com.sinsiway.intern.domain.SW_Execute_Log;

public interface ExecuteLogDAO {
	public void regist(SW_Execute_Log exec_log);
	public String selectSql(SW_Execute_Log exec_log);
	public void update(SW_Execute_Log exec_log);
	public void delete(int id);
}
