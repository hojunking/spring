package com.song.web.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.song.web.board.domain.BoardVO;
import com.song.web.board.domain.Criteria;
import com.song.web.board.mapper.BoardMapper;

@Service
public class BoardServiceImpl implements BoardService {
	@Autowired BoardMapper boardMapper;

	public int insert(BoardVO vo) {
		return boardMapper.insert(vo);
	}

	public int update(BoardVO vo) {
		return boardMapper.update(vo);
	}

	public int delete(BoardVO vo) {
		return boardMapper.delete(vo);
	}
	public BoardVO read(BoardVO vo) {
		return boardMapper.read(vo);
	}
	public List<BoardVO> getList(Criteria cri) {
		return boardMapper.getList(cri);
	}
	@Override
	public int getTotalCount(Criteria cri) {
		return boardMapper.getTotalCount(cri);
	}

	
}
