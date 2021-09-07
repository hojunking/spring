package com.song.web.board.service;


import java.util.List;

import com.song.web.board.domain.Criteria;
import com.song.web.board.domain.ReplyVO;

public interface ReplyService {
	public int insert(ReplyVO vo);
	public int modify(ReplyVO vo);
	public int delete(ReplyVO vo);
	public List<ReplyVO> getList(Criteria cri,Long bno);
	public ReplyVO read(ReplyVO vo);
	public int getTotalCount(Criteria cri);
}
