package com.sinsiway.intern.model.repository.ExecuteLog;

import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sinsiway.intern.domain.SW_Execute_Log;

@Repository
@Mapper
public class MybatisExecuteLogDAO implements ExecuteLogDAO{
	@Autowired
	SqlSessionTemplate sqlSessionTemplate;
	
	@Override
	public void regist(SW_Execute_Log exec_log) {
		sqlSessionTemplate.insert("ExecInfo.insert", exec_log);
		
	}

	@Override
	public String selectSql(SW_Execute_Log exec_log) {
		return sqlSessionTemplate.selectOne("ExecInfo.selectSql", exec_log);
		
	}

	@Override
	public void update(SW_Execute_Log exec_log) {
		sqlSessionTemplate.update("ExecInfo.update", exec_log);
		
	}

	@Override
	public void delete(int id) {
		sqlSessionTemplate.delete("ExecInfo.delete", id);
		
	}

}
