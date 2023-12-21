package com.kh.ex01.config;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

@Configuration
@ComponentScan(basePackages = {"com.kh.ex01"})
@MapperScan(basePackages = {"com.kh.ex01.mapper"})
public class RootConfig {
	
	// javax.sql.DataSource
	
	@Bean
	public DataSource dataSource() {
		HikariConfig config = new HikariConfig();
		config.setDriverClassName("net.sf.log4jdbc.sql.jdbcapi.DriverSpy");
		config.setJdbcUrl("jdbc:log4jdbc:oracle:thin:@localhost:1521:xe");
		config.setUsername("SPRING");
		config.setPassword("1234");
		
		HikariDataSource ds = new HikariDataSource(config);
		return ds;
	}
	
	@Bean
	public SqlSessionFactory sqlSessionFactory() throws Exception {
		SqlSessionFactoryBean factoryBean = 
				new SqlSessionFactoryBean();
		
		factoryBean.setDataSource(dataSource());
		SqlSessionFactory factory = factoryBean.getObject();
		return factory;
		
	}
	
	
	
}
