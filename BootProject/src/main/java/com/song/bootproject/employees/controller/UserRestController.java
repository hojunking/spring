package com.song.bootproject.employees.controller;


import com.song.bootproject.employees.domain.User;
import com.song.bootproject.employees.service.UserServiceDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserRestController {
    //@Autowired UserServiceDAO service;

    private UserServiceDAO service;

    public UserRestController(UserServiceDAO service){
        this.service = service;
    } //생성자

    @GetMapping("/users")
    public List<User> retrieveAllUsers(){
        return service.findAll();
    }
    // GET /users/1 -> String 형태로 전달된다.(int -> string
    //Integer로 Mapping 된다.)
    @GetMapping("/users/{id}")
    public User retrieveUser(@PathVariable int id){
        return service.findOne(id);
    }
    //insert User data
    @PostMapping("/users")
    public void createUser(@RequestBody User user){
        User savedUser = service.save(user);
    }
}
