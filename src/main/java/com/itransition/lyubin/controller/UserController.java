package com.itransition.lyubin.controller;

import com.itransition.lyubin.dto.UserDTO;
import com.itransition.lyubin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/users")
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "getAll")
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(this.userService.findAll());
    }

    @GetMapping(value = "get/{id}")
    public ResponseEntity<?> getUserById(@PathVariable(value = "id") Integer id) {
        return ResponseEntity.ok(this.userService.findById(id));
    }

    @PostMapping(value = "create")
    public ResponseEntity create(@Valid @RequestBody UserDTO userDTO) {
        userService.createUser(userDTO);
        HttpHeaders headers = new HttpHeaders();
        headers.add("token", "test-token");
        return new ResponseEntity(headers, HttpStatus.OK);
    }

}