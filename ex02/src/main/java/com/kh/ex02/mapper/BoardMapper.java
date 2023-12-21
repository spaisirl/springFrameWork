package com.kh.ex02.mapper;

import java.util.List;

import com.kh.ex02.domain.BoardVO;

public interface BoardMapper {
	
//	@Select("select * from tbl_board order by bno desc")
	public List<BoardVO> getList();
	
	public void insert(BoardVO boardVO);
	
	public void insertSelectKey(BoardVO boardVO);
	
	public BoardVO read(Long bno);
	
	public int delete(Long bno);
	
	public int update(BoardVO boardVO);
	
}
