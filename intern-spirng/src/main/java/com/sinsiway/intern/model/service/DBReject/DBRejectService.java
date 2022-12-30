package com.sinsiway.intern.model.service.DBReject;

import com.sinsiway.intern.domain.SW_Database_Reject;

public interface DBRejectService {
	public void insert(SW_Database_Reject db_reject);
	public String select(int database_id);
	public void delete(SW_Database_Reject db_reject);
}
