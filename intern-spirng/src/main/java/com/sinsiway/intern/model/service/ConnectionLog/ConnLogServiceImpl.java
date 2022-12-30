package com.sinsiway.intern.model.service.ConnectionLog;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sinsiway.intern.domain.SW_Connection_Log;
import com.sinsiway.intern.model.repository.ConnectionLog.ConnLogDAO;

@Service
public class ConnLogServiceImpl implements ConnLogService{
	@Autowired
	private ConnLogDAO connLogDAO;
	
	@Override
	public void regist(SW_Connection_Log connLog) {
		connLogDAO.regist(connLog);
		
	}

}
