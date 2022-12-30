package com.sinsiway.intern.model.repository.DBReject;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sinsiway.intern.domain.SW_Database_Reject;

@Repository
public class MybatisDBRejectDAO implements DBRejectDAO{
	@Autowired
	SqlSessionTemplate sqlSessionTemplate;
	@Override
	public void insert(SW_Database_Reject db_reject) {
		sqlSessionTemplate.insert("Reject.insert", db_reject);
		
	}
	@Override
	public String select(int database_id) {
		return sqlSessionTemplate.selectOne("Reject.selectOne", database_id);
		
	}
	@Override
	public void delete(SW_Database_Reject db_reject) {
		sqlSessionTemplate.delete("Reject.delete", db_reject);
		
	}

}
