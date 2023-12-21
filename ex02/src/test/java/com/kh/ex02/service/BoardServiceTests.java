package com.kh.ex02.service;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.kh.ex02.domain.BoardVO;

import lombok.extern.log4j.Log4j;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/*.xml"})
@Log4j
public class BoardServiceTests {
	
	@Autowired
	private BoardService boardService; // BoardServiceImpl
	
	@Test
	public void testGetList() {
		log.info("boardService:" + boardService);
		List<BoardVO> list = boardService.getList();
		log.info("list" + list);
	}
	
	@Test
	public void testRegister() {
		boardService.register(BoardVO.builder()
				.title("제목-14")
				.content("내용-14")
				.writer("작성자-14")
				.build());
	}
	
	@Test
	public void testGet() {
		BoardVO boardVO = boardService.get(13L);
		log.info("boardVO:" + boardVO);
	}
	
	@Test
	public void testRemove() {
		boolean result = boardService.remove(14L);
		log.info("result" + result);
	}
	
	@Test
	public void testModify() {
		boolean result = boardService.modify(BoardVO.builder()
				.title("제목-13 수정")
				.content("내용 13-수정")
				.writer("작성자 13-수정")
				.bno(13L)
				.build());
		log.info("result" + result);
	}
}
