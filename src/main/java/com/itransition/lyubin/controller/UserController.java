package com.itransition.lyubin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/users")
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "")
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(this.userService.findAll());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<?> getUserById(@PathVariable Integer id) {
        return ResponseEntity.ok(this.getUserById(id));
    }

    @GetMapping(value = "/update")
    public ResponseEntity<?> updateUserById(@RequestParam int id) {
        return ResponseEntity.ok("update");
    }

}
