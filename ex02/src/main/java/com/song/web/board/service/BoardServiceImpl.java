package com.song.web.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.song.web.board.domain.BoardAttachVO;
import com.song.web.board.domain.BoardVO;
import com.song.web.board.domain.Criteria;
import com.song.web.board.mapper.BoardAttachMapper;
import com.song.web.board.mapper.BoardMapper;

@Service
public class BoardServiceImpl implements BoardService {
	@Autowired BoardMapper boardMapper;
	@Autowired BoardAttachMapper attachMapper;
	
	
	public int insert(BoardVO vo) {
		boardMapper.insert(vo);
		if(vo.getAttachList()==null)
			return 1;
		for(BoardAttachVO attach : vo.getAttachList()) {
			attach.setBno(vo.getBno());
			attachMapper.insert(attach);
		}
		return 1;
	}

	public int update(BoardVO vo) {
		return boardMapper.update(vo);
	}

	public int delete(BoardVO vo) {
		return boardMapper.delete(vo);
	}
	public BoardVO read(BoardVO vo) {
		vo=boardMapper.read(vo);
		vo.setAttachList(attachMapper.findByBno(vo.getBno()));
		return vo;
	}
	public List<BoardVO> getList(Criteria cri) {
		return boardMapper.getList(cri);
	}
	@Override
	public int getTotalCount(Criteria cri) {
		return boardMapper.getTotalCount(cri);
	}

	
}
