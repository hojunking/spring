package com.song.bootproject.employees.controller;

import com.song.bootproject.employees.domain.EmployeeVO;
import com.song.bootproject.employees.service.EmployeesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EmployeesRestController {
    @Autowired
    EmployeesService service;

    @GetMapping(path = "/emp")
    public List<EmployeeVO> empGet(){
        return service.getList();
    }

    @GetMapping(path = "/test")
    public String Test() {

        return "test";
    }
    // alt + enter
    @GetMapping(path = "/hello-world-bean")
    public HelloWorldBean helloWorldBean(){
        return new HelloWorldBean("Hello World");
        //new 연산자 인스턴스 생성를 return
    }

    @GetMapping(path = "/hello-world-bean/path-variable/{name}")
    public HelloWorldBean helloWorldBean(@PathVariable String name){
        //@PathVariable("") 가변값
        return new HelloWorldBean(String.format("Hello World,%s",name));
        //new 연산자 인스턴스 생성 후 Path variable로 받은 name 객체의 내용을 다시 return한다
    }

}
