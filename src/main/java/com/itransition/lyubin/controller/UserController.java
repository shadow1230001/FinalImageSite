package com.itransition.lyubin.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping( value = "/user" )
public class UserController {

    @GetMapping( value = "/getall" )
    public ResponseEntity<?> getAllUsers(){
        return ResponseEntity.ok("users");
    }

    @GetMapping( value = "/get" )
    public ResponseEntity<?> getUserById(@RequestParam int id){
        return ResponseEntity.ok("user");
    }

    @GetMapping( value = "/update" )
    public ResponseEntity<?> updateUserById(@RequestParam int id){
        return ResponseEntity.ok("update");
    }

}
