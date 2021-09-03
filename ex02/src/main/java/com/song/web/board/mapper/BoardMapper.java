package com.song.web.board.mapper;

import java.util.List;

import com.song.web.board.domain.BoardVO;

public interface BoardMapper {
	//CRUD 기본 interface
	
	//등록
	public int insert(BoardVO vo);
	//수정
	public int update(BoardVO vo);
	//삭제
	public int delete(BoardVO vo);
	//단건조회
	public BoardVO read(BoardVO vo);
	//전체조회
	public List<BoardVO> getList();
}
