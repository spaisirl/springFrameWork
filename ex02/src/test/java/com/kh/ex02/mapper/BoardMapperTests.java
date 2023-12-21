package com.kh.ex02.mapper;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.kh.ex02.domain.BoardVO;
import com.kh.ex02.service.BoardService;

import lombok.extern.log4j.Log4j;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/*.xml"})
@Log4j
public class BoardMapperTests {
	
		@Autowired
		private BoardMapper boardMapper;
		
		@Autowired
		private BoardService boardService;
		
		@Test
		public void testGetList() {
			log.info("boardService:" + boardService);
//			List<BoardVO> list =  boardMapper.getList();
//			for (BoardVO vo : list) {
//				System.out.println("vo:" + vo);
//			}
//			
//			assertNotNull(list);
//			assertTrue(list.size() == 10);
		}
		
		@Test
		public void testInsert() {
			BoardVO boardVO = BoardVO.builder()
					.title("제목-12")
					.content("내용-12")
					.writer("user-12")
					.build();
			boardMapper.insert(boardVO);
		}
		
		@Test
		public void testInsertSelectKey() {
			BoardVO boardVO = BoardVO.builder()
					.title("제목-13")
					.content("내용-13")
					.writer("user-13")
					.build();
			boardMapper.insert(boardVO);
		}
		
		
		
		@Test
		public void testRead() {
		// bno 을 가지고 와서 -> boardVO title에서 제목-1 을 읽음
			Long bno = 2L;
			BoardVO boardVO = boardMapper.read(bno);
			log.info("boardVO:"+ boardVO);
			assertEquals(boardVO.getTitle(), "제목-2 수정");
		}
		
		@Test
		public void testDelete() {
			Long bno = 1L;
			int count = boardMapper.delete(bno);
			log.info("count" + count);
		}
		
		@Test
		public void testUpdate() {
			
			BoardVO boardVO = BoardVO.builder()
					.title("제목-2 수정")
					.content("내용-2 수정")
					.writer("작성자-2 수정")
					.bno(2L)
					.build();
			boardMapper.update(boardVO);
		}
	

}
