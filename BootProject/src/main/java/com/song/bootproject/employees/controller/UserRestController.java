package com.song.bootproject.employees.controller;


import com.song.bootproject.employees.domain.User;
import com.song.bootproject.employees.exceptions.UserNotFoundException;
import com.song.bootproject.employees.service.UserServiceDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
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
        User user = service.findOne(id);

        //예외처리하기
        if(user ==null){
            throw  new UserNotFoundException(String.format("ID[%s] not found", id ));
        }

        return user;
    }
    //insert User data

    @PostMapping("/users")
    public ResponseEntity<User> createUser(@RequestBody User user){
        User savedUser = service.save(user);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedUser.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }

    //삭제
    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable int id ){
        User user =service.deleteById(id);
        if(user == null)
            throw new UserNotFoundException(String.format("ID[%s] not found", id ));
    }
}
