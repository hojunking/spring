package co.henry.web.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.henry.web.board.domain.BoardVO;
import co.henry.web.board.mapper.BoardMapper;
@Service

public class BoardServiceImpl implements BoardService {
	@Autowired BoardMapper map;
	@Override
	public List<BoardVO> getList() {
		return map.getList();
	}
	@Override
	public BoardVO read(BoardVO vo) {
		return map.read(vo);
	}
	@Override
	public int modify(BoardVO vo) {
		// TODO Auto-generated method stub
		return map.modify(vo);
	}
	@Override
	public int delete(BoardVO vo) {
		// TODO Auto-generated method stub
		return map.delete(vo);
	}
	@Override
	public int insert(BoardVO vo) {
		// TODO Auto-generated method stub
		return map.insert(vo);
	}

}
