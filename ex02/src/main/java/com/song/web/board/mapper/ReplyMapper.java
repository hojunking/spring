package com.song.web.board.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.song.web.board.domain.Criteria;
import com.song.web.board.domain.ReplyVO;

public interface ReplyMapper {
	
	public int insert(ReplyVO vo);
	public int modify(ReplyVO vo);
	public int delete(ReplyVO vo);
	public List<ReplyVO> getListPage(@Param("cri") Criteria cri,
					@Param("bno") Long bno);
	public ReplyVO read(ReplyVO vo);
	public int getTotalCount(Long bno);

}
