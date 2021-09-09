package com.song.web.board.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.song.web.board.domain.Criteria;
import com.song.web.board.domain.ReplyPageVO;
import com.song.web.board.domain.ReplyVO;
import com.song.web.board.mapper.BoardMapper;
import com.song.web.board.mapper.ReplyMapper;
@Service
public class ReplyServiceImpl implements ReplyService {
	
	@Autowired ReplyMapper map;
	@Autowired BoardMapper boardMap;
	@Override
	public int insert(ReplyVO vo) {
		boardMap.updateReplycnt(vo.getBno(), 1L);
		return map.insert(vo);
	}

	@Override
	public int modify(ReplyVO vo) {
		// TODO Auto-generated method stub
		return map.modify(vo);
	}

	@Override
	public int delete(ReplyVO vo) {
		vo= map.read(vo);
		System.out.println("무엇이 들었을 까요~"+vo);
		boardMap.updateReplycnt(vo.getBno(), -1L);
		return map.delete(vo);
	}


	@Override
	public ReplyVO read(ReplyVO vo) {
		// TODO Auto-generated method stub
		return map.read(vo);
	}

	@Override
	public int getTotalCount(Long bno) {
		// TODO Auto-generated method stub
		return map.getTotalCount(bno);
	}

	@Override
	public ReplyPageVO getListPage(Criteria cri, Long bno) {
			ReplyPageVO vo = new ReplyPageVO();
			vo.setReplyCnt(map.getTotalCount(bno));
			vo.setList(map.getListPage(cri, bno));
		return vo;
	}

}
