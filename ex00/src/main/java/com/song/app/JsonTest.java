package com.song.app;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.java.Log;

@Log
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/spring/*-context.xml")
public class JsonTest {
		
	@Test
	public void test1() throws Exception {
		ObjectMapper mapper = new ObjectMapper();
		Employees emp= new Employees();
		emp.setFirst_name("song");
		emp.setEmployee_id("100");
		
		String str= mapper.writeValueAsString(emp);
		//Json으로 parsing 하기
		log.info(str);
		
	}
}
