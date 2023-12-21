package com.kh.ex00.sample;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.kh.ex00.config.RootConfig;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {RootConfig.class})
public class SampleTests {
	
	@Autowired
	private Restraunt restraunt;
	
	@Autowired
	private Chef chef;
	
	@Test
	public void testRestaunt() {
		assertNotNull(restraunt);
		System.out.println("Restraunt:" + restraunt);
		//log.info("restraunt:" + restraunt);
		
	}
	
	@Test
	public void testChef() {
		System.out.println("chef:" + chef);
	}
}
