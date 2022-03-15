package com.song.bootproject.employees.controller;

import com.song.bootproject.employees.domain.EmployeeVO;
import com.song.bootproject.employees.service.EmployeesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeesRestController {
    @Autowired
    EmployeesService service;

    //전체조회
    @GetMapping(path = "/emp")
    public List<EmployeeVO> empGet(){
        return service.getList();
    }
    //단건조회
    @GetMapping("/emp/{id}")
    public EmployeeVO getOne(@PathVariable int id){
        EmployeeVO vo =new EmployeeVO();
        vo.setEmployeeId(id);
        return service.read(vo);
    }
    //삽입
    @PostMapping("/emp")
    public void insert(EmployeeVO vo){
        service.insert(vo);
    }
    //수정
    @PostMapping("/empUpdate")
    public void update(EmployeeVO vo){
        service.update(vo);
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
