package com.sinsiway.intern.model.repository.DBReject;

import com.sinsiway.intern.domain.SW_Database_Reject;

public interface DBRejectDAO {
	public void insert(SW_Database_Reject db_reject);
	public String select(int database_id);
	public void delete(SW_Database_Reject db_reject);
}
