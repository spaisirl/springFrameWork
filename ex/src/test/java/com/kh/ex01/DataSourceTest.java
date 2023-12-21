package com.kh.ex01;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.kh.ex01.dao.TestDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/*.xml"})
public class DataSourceTest {
	
	@Autowired
	private DataSource dataSource;
	
	@Autowired
	private TestDAO testDAO;
	
	@Test
	public void testDataSource() throws Exception {
		System.out.println("dataSource:" + dataSource);
	}
	
	@Test
	public void testGetToday() throws Exception {
		String today = testDAO.getToday();
		System.out.println("today:" + today);
		
	}
}
