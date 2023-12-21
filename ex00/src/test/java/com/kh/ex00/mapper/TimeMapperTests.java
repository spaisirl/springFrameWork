package com.kh.ex00.mapper;

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
public class TimeMapperTests {
	@Autowired
	TimeMapper timeMapper;
	
	@Test
	public void testTimeMapper() {
		log.info("timeMapper" + timeMapper);
	}
	
	@Test
	public void testGetTime() {
		String time = timeMapper.getTime();
		log.info("time" + time);
		String time2 = timeMapper.getTime2();
		log.info("time" + time2);
	}
	
}
