package co.henry.web;

import static org.junit.Assert.assertEquals;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import co.henry.web.board.domain.BoardVO;
import co.henry.web.board.service.BoardServiceImpl;
import lombok.extern.java.Log;

@Log
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/spring/*-context.xml")
public class BoardServiceClient {
	
	@Autowired BoardServiceImpl service;
	BoardVO vo = new BoardVO();
	@Test
	@Ignore
	public void getList() {
		log.info(service.getList().toString());
	}
	
	@Test
	@Ignore
	public void insert() {
		vo.setTitle("타이틀2");
		vo.setContent("내용2");
		vo.setWriter("작성자2");
		service.insert(vo);
//		log.info(service.toString());
//		getList();
		log.info(Long.toString(vo.getBno()));
	}
	@Test
	@Ignore
	public void read() {
		vo.setBno(5);
		log.info(service.read(vo).toString());
	}
	@Test
	@Ignore
	public void modify() {
		vo.setTitle("타이틀변경");
		vo.setContent("내용변경이요");
		vo.setWriter("작성자 변경");
		vo.setBno(5);
		int result = service.modify(vo);
		assertEquals(result, 1);
		log.info(service.read(vo).toString());
	}
	@Test
	public void delete( ) {
		vo.setBno(4);
		int result=service.delete(vo);
		assertEquals(result, 1);
		
	}
}
