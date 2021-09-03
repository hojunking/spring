package com.song.web.board;

import static org.junit.Assert.assertEquals;


import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.song.web.board.domain.BoardVO;
import com.song.web.board.service.BoardService;

import lombok.extern.java.Log;

@Log
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/spring/*-context.xml")
public class BoardMapperClient {
	
	@Autowired BoardService boardService;
	@Test
	public void getList() {
		log.info(boardService.getList().toString());
	}
	@Test
	@Ignore
	public void insert() {
		BoardVO vo= new BoardVO();
		vo.setTitle("새로 작성!");
		vo.setContent("새로운 내용");
		vo.setWriter("호준이");
		boardService.insert(vo);
		
//		log.info(boardMapper.toString());
		log.info(Long.toString(vo.getBno())); //bno값은 selectjey값에 넣어저 있어서 조회가 가능하다. 
	}
	
	@Test
	@Ignore
	public void read() {
		BoardVO vo= new BoardVO();
		vo.setBno(8);
		boardService.read(vo);
		log.info(boardService.toString());
	}
	
	@Test
	@Ignore
	public void delete() {
		BoardVO vo = new BoardVO();
		vo.setBno(5);
		int result= boardService.delete(vo);
		
		getList();
		assertEquals(result, 1);
	}
	@Test
	@Ignore
	public void update() {
		BoardVO vo = new BoardVO();
		vo.setTitle("변경");
		vo.setContent("변경내용");
		vo.setWriter("변경자");
		vo.setBno(5);
		boardService.update(vo);
		getList();
	}
}
