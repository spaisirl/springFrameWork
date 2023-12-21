package com.kh.ex01.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class TestDAO {

	private static final String NAMESPACE="test.";
	
	@Autowired
	private SqlSession sqlSession;
	
	public String getToday() {
		// mapper.TestMapp.xml
		String today = sqlSession.selectOne(NAMESPACE + "getToday");
		return today;
	}
	
	
}
