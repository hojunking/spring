package co.song.web;



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
	
	@Autowired EmployeeService service;
	
	@Test
	@Ignore
	public void test1() {
		EmployeeVO emp = new EmployeeVO();

		log.info(emp.getEmployeeId());
	}
	@Test
	@Ignore
	public void getList() {
		EmployeeVO emp = new EmployeeVO();
		emp.setEmployeeId("100");
		log.info(service.getList(emp).toString());
	}
	@Test
	@Ignore
	public void test2() {
		log.info(service.list().toString());
	}
	
	@Test
	public void test3() {
		EmployeeVO emp = new EmployeeVO();
		emp.setEmployeeId("199");
		emp.setFirstName("song");
		emp.setLastName("hojun");
		emp.setEmail("song@naver.com");
		emp.setPhoneNumber("01099003097");
		emp.setHireDate("2022-03-02");
		emp.setJobId("AD_VP");
		emp.setSalary("2000");
		emp.setCommissionPct("0.2");
		emp.setManagerId("101");
		emp.setDepartmentId("10");
		service.insert(emp);
		log.info(service.list().toString());
		emp.setFirstName("jang");
		emp.setSalary("150000");
		emp.setDepartmentId("10");
		emp.setEmployeeId("199");
		service.update(emp);
		log.info(service.getList(emp).toString());
		service.delete(emp);
		log.info(service.list().toString());
	}
}
