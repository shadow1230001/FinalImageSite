package com.itransition.lyubin.controller;


import com.itransition.lyubin.dto.PersonContext;
import com.itransition.lyubin.dto.UserDTO;
import com.itransition.lyubin.security.JwtTokenHandler;
import com.itransition.lyubin.service.AuthService;
import com.itransition.lyubin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@CrossOrigin
@RestController
@RequestMapping(value = "/users")
public class UserController {

    private UserService userService;
    private AuthService authService;
    private JwtTokenHandler jwtTokenHandler;

    @Autowired
    public UserController(UserService userService, AuthService authService,
                          JwtTokenHandler jwtTokenHandler) {
        this.userService = userService;
        this.authService = authService;
        this.jwtTokenHandler = jwtTokenHandler;
    }

    @GetMapping(value = "getAll")
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(this.userService.findAll());
    }

    @GetMapping(value = "get/{id}")
    public ResponseEntity<?> getUserById(@PathVariable(value = "id") Integer id) {
        return ResponseEntity.ok(this.userService.findById(id));
    }

    @PostMapping(value = "singup")
    public ResponseEntity singup(@RequestBody PersonContext personContext) {
        String res = "";
        if (this.authService.singup(personContext.getUserDTO(),
                personContext.getProfileDTO(), personContext.getImageDTO())) {
            res = this.jwtTokenHandler.createTokenForUser(personContext.getUserDTO().toUser());
        }

        return new ResponseEntity(res, HttpStatus.OK);
    }

    @PostMapping(value = "login")
    public ResponseEntity login(@Valid @RequestBody UserDTO userDTO) {
        String res = "";
        if (this.authService.login(userDTO)) {
            res = this.jwtTokenHandler.createTokenForUser(userDTO.toUser());
        }
        return new ResponseEntity(res, HttpStatus.OK);
    }


}