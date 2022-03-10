package com.song.bootproject.employees.controller;

import com.song.bootproject.domain.EmployeeVO;
import com.song.bootproject.service.EmployeesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EmployeesController {
    @Autowired EmployeesService service;

    @GetMapping(path = "/emp")
    public List<EmployeeVO> empGet(){
        return service.getList();
    }

    @GetMapping(path = "/test")
    public String Test(){

        return "test";
    }

}
