package com.song.web.board;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.song.web.board.domain.Criteria;
import com.song.web.board.mapper.ReplyMapper;
import com.song.web.board.service.ReplyService;

import lombok.extern.java.Log;

@Log
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/spring/*-context.xml")
public class ReplyMapperClient {
	@Autowired ReplyService Service;
	@Autowired ReplyMapper map;
	
	@Test
	public void getList() {
		Criteria cri = new Criteria(1,10);
		log.info(Service.getListPage(cri, 2097159L).toString());
		
	}
	
}
