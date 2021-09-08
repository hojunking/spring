package com.song.web.board.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.song.web.board.domain.BoardVO;
import com.song.web.board.domain.Criteria;

public interface BoardMapper {
	//CRUD 기본 interface
	
	//total count
	public int getTotalCount(Criteria cri);
	//등록
	public int insert(BoardVO vo);
	//수정
	public int update(BoardVO vo);
	//삭제
	public int delete(BoardVO vo);
	//단건조회
	public BoardVO read(BoardVO vo);
	//전체조회
	public List<BoardVO> getList(Criteria cri);
	//댓글 수 업데이트
	public void updateReplycnt(
			@Param("bno") Long bno,
			@Param("amount") Long amount
			);
	//리턴값 없어서 interface 필요 없다.
}
