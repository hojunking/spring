package com.song.bootproject.employees.controller;

import com.song.bootproject.employees.domain.EmployeeVO;
import com.song.bootproject.employees.service.EmployeesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class EmployeeController {
    @Autowired
    EmployeesService service;
    @RequestMapping("/")
    public String main(){
        return "index";
    }
    @GetMapping("/empList")
    public String empList(Model model){
        model.addAttribute("list",service.getList());
        return "employees/empList";
    }
    
    @GetMapping("/getEmp/{id}")
    public String getEmp(@PathVariable int id,Model model){
        EmployeeVO vo = new EmployeeVO();
        vo.setEmployeeId(id);
        model.addAttribute("getEmp",service.read(vo));
        return "employees/getUser";
    }
}
