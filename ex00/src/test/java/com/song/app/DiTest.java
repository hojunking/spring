package com.song.app;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.extern.java.Log;
@Log
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/spring/*-context.xml")
public class DiTest {
	//IoC(역제어) : 객체관리를 컨테이너 함
	//DI : dependency Injection
	@Autowired Employees emp; //컨테이너에서 주입받음
	@Test
	public void test1() {
//		Employees emp = new Employees();
		//new 생성자 만들지 않고 bean으로 들고 오는방법
		log.info(emp.getEmployee_id());
		//@autowired를 통해서 root-context파일에 선언한 bean객체를 통해 받아옴
	}

}
