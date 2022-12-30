package com.sinsiway.intern.model.service.DBReject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sinsiway.intern.domain.SW_Database_Reject;
import com.sinsiway.intern.model.repository.DBReject.DBRejectDAO;

@Service
public class DBRejectServiceImpl implements DBRejectService{
	@Autowired
	DBRejectDAO dbRejectDAO;
	@Override
	public void insert(SW_Database_Reject db_reject) {
		dbRejectDAO.insert(db_reject);
		
	}
	@Override
	public String select(int database_id) {
		return dbRejectDAO.select(database_id);
		
	}
	@Override
	public void delete(SW_Database_Reject db_reject) {
		dbRejectDAO.delete(db_reject);
		
	}

}
