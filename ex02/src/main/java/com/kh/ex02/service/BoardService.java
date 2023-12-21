package com.kh.ex02.service;

import java.util.List;

import com.kh.ex02.domain.BoardVO;

public interface BoardService {

	// 글 목록 가져오기
	public List<BoardVO> getList();
	
	// 글 등록하기
	public void register(BoardVO boardVO);
	
	// 글 하나 가져오기
	public BoardVO get(Long bno);
	
	// 글 삭제하기
	public boolean remove(Long bno);
	
	// 글 수정
	public boolean modify(BoardVO boardVO);
}
