package com.kh.ex00.persistence;

import static org.junit.Assert.assertNotNull;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.kh.ex00.config.RootConfig;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {RootConfig.class})
@Log4j
public class DataSourceTests  {
	
	@Autowired
	private DataSource dataSource;
	
	@Autowired
	private SqlSessionFactory sqlSessionFactory;
	
	@Test
	public void testExistDataSource() {
		assertNotNull(dataSource);
		log.info("dataSource" + dataSource);
	}
	
	@Test
	public void testSqlSessionFactory() {
		log.info("sqlSessionFactory:" + sqlSessionFactory);
		SqlSession sqlSession = sqlSessionFactory.openSession();
		log.info("sqlSession" + sqlSession);
	}

}
