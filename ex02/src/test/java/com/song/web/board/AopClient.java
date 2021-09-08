package com.song.web.board;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.song.web.member.domain.UserVO;
import com.song.web.member.service.UserService;

import lombok.extern.java.Log;

@Log
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/spring/*-context.xml")
public class AopClient {

	
	@Autowired UserService service;  
	@Test
	public void test1() {
		UserVO vo = new UserVO();
		vo.setId("test");
		service.getUser(vo);
		//service.getUserList(null);
	}
}
