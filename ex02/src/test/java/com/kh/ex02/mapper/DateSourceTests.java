package com.kh.ex02.mapper;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.extern.log4j.Log4j;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/*.xml"})
@Log4j
public class DateSourceTests {
	
		@Autowired
		private DataSource dataSource;
		
		@Test
		public void testExistDataSource() {
			log.info("dataSource"+ dataSource);
		}
	

}
