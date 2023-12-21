package com.kh.ex02.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.kh.ex02.domain.BoardVO;
import com.kh.ex02.mapper.BoardMapper;

import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
@Service
public class BoardServiceImpl implements BoardService {
	
	private final BoardMapper boardMapper;

	@Override
	public List<BoardVO> getList() {
		//log.info("boardMapper:" + boardMapper);
		return boardMapper.getList();
	}

	@Override
	public void register(BoardVO boardVO) {
		boardMapper.insert(boardVO);
	}

	@Override
	public BoardVO get(Long bno) {
		
		return boardMapper.read(bno);
	}

	@Override
	public boolean remove(Long bno) {
		
		int count = boardMapper.delete(bno);
		if (count > 0) {
			return true;
		}
		
		return false;
	}

	@Override
	public boolean modify(BoardVO boardVO) {
		int count = boardMapper.update(boardVO);
		
		if (count == 1 ) {
			return true;
		}
		
		return false;
	}

}
