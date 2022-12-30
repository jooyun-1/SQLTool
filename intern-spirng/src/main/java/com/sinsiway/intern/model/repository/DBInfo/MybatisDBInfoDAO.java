package com.sinsiway.intern.model.repository.DBInfo;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sinsiway.intern.domain.SW_Database;

@Repository
@Mapper
public class MybatisDBInfoDAO implements DBInfoDAO {
	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	@Override
	public List selectAll() {
		
		return sqlSessionTemplate.selectList("Info.selectAll");
	}

	@Override
	public void regist(SW_Database db_info) {
		sqlSessionTemplate.insert("Info.insert",db_info);

	}

	@Override
	public SW_Database selectOne(int database_id) {
		return sqlSessionTemplate.selectOne("Info.selectOne", database_id);
		
	}

	@Override
	public void update(SW_Database db_info) {
		sqlSessionTemplate.update("Info.update", db_info);
		
	}

	@Override
	public void delete(SW_Database db_info) {
		sqlSessionTemplate.delete("Info.delete", db_info);
		
	}
	
	

}
