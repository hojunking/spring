package com.song.bootproject.employees.controller;

import com.song.bootproject.service.EmployeesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeesController {
    @Autowired EmployeesService service;


}
