package com.sinsiway.intern.model.repository.ConnectionLog;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sinsiway.intern.domain.SW_Connection_Log;

@Repository
public class MybatisConnLogDAO implements ConnLogDAO{
	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	@Override
	public void regist(SW_Connection_Log connLog) {
		sqlSessionTemplate.insert("ConnLog.insert", connLog);
		
	}

}
