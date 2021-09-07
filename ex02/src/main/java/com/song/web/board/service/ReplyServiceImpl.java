package com.song.web.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.song.web.board.domain.Criteria;
import com.song.web.board.domain.ReplyVO;
import com.song.web.member.mapper.ReplyMapper;
@Service
public class ReplyServiceImpl implements ReplyService {
	
	@Autowired ReplyMapper map;
	@Override
	public int insert(ReplyVO vo) {
		// TODO Auto-generated method stub
		return map.insert(vo);
	}

	@Override
	public int modify(ReplyVO vo) {
		// TODO Auto-generated method stub
		return map.modify(vo);
	}

	@Override
	public int delete(ReplyVO vo) {
		// TODO Auto-generated method stub
		return map.delete(vo);
	}

	@Override
	public List<ReplyVO> getList(Criteria cri,Long bno) {
		// TODO Auto-generated method stub
		return map.getList(cri,bno);
	}

	@Override
	public ReplyVO read(ReplyVO vo) {
		// TODO Auto-generated method stub
		return map.read(vo);
	}

	@Override
	public int getTotalCount(Criteria cri) {
		// TODO Auto-generated method stub
		return map.getTotalCount(cri);
	}

}
