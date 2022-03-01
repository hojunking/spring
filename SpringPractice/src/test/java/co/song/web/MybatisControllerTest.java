package co.song.web;


import java.rmi.server.ServerCloneException;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import co.song.web.employee.domain.EmployeeVO;
import co.song.web.employee.service.EmployeeService;
import lombok.extern.java.Log;

@Log
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:/spring/*-context.xml",
	"file:src\\main\\webapp\\WEB-INF\\spring\\appServlet\\servlet-context.xml"})
public class MybatisControllerTest {
	
	EmployeeVO emp = new EmployeeVO();
	@Autowired EmployeeService service;
	
	@Test
	@Ignore
	public void test1() {
		log.info(emp.getEmployeeId());
	}
	@Test
	public void getList() {
		emp.setEmployeeId("100");
		log.info(service.getList(emp).toString());
	}
	@Test
	@Ignore
	public void test2() {
		log.info(service.list().toString());
	}
}
