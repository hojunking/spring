package co.song.web.employee.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import co.song.web.employee.service.EmployeeService;

@Controller
public class EmployeeController {
	
	@Autowired EmployeeService service;
	
	@GetMapping("/listEmp")
	public void list(Model model) {
		System.out.println("시작\n");
		model.addAttribute("getList",service.list());
	}
}
