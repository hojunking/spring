package com.song.web.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.song.web.board.domain.BoardAttachVO;
import com.song.web.board.mapper.BoardAttachMapper;
@Service
public class BoardAttachServiceImpl implements BoardAttachSerivce {
	@Autowired BoardAttachMapper map;
	@Override
	public void insert(BoardAttachVO vo) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(String uuid) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<BoardAttachVO> findByBno(Long bno) {
		// TODO Auto-generated method stub
		return map.findByBno(bno);
	}

	@Override
	public void deleteAll(Long bno) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<BoardAttachVO> getOldFiles() {
		// TODO Auto-generated method stub
		return map.getOldFiles();
	}

	@Override
	public BoardAttachVO read(String uuid) {
		// TODO Auto-generated method stub
		return map.read(uuid);
	}

}
