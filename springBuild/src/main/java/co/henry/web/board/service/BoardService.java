package co.henry.web.board.service;

import java.util.List;

import co.henry.web.board.domain.BoardVO;

public interface BoardService {
	public List<BoardVO> getList();
	public BoardVO read(BoardVO vo);
	public int modify(BoardVO vo);
	public int delete(BoardVO vo);
	public int insert(BoardVO vo);
	
}
