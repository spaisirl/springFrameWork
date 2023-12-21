package com.kh.ex01;

import java.sql.Connection;
import java.sql.DriverManager;

import org.junit.Test;

public class JDBCTest {
	
	private String DRIVER_NAME = "oracle.jdbc.driver.OracleDriver";
	private String ID = "SPRING";
	private String PW = "1234";
	private String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	
	@Test
	public void testConnection() throws Exception {
		Class.forName(DRIVER_NAME);
		Connection conn = DriverManager.getConnection(URL, ID, PW);
		System.out.println("conn:" + conn);
		if (conn != null) {
			conn.close();
		}
	}
	
}
