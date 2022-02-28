package co.song.web.employee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import co.song.web.employee.domain.EmployeeVO;
import co.song.web.employee.service.EmployeeService;

@Controller
public class EmployeeController {
	
	@Autowired EmployeeService service;
	
	@GetMapping("/listEmp")
	public List<EmployeeVO> list() {
		System.out.println("시작\n");
		return service.getList();
	}
}
