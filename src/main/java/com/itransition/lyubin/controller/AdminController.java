package com.itransition.lyubin.controller;

import com.itransition.lyubin.security.JwtTokenHandler;
import com.itransition.lyubin.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping(value = "admin")
public class AdminController {

    private AdminService adminService;
    private JwtTokenHandler jwtTokenHandler;

    @Autowired
    public AdminController(AdminService adminService, JwtTokenHandler jwtTokenHandler) {
        this.adminService = adminService;
        this.jwtTokenHandler = jwtTokenHandler;
    }

    @GetMapping(value = "getAll")
    public ResponseEntity<?> getAll(@RequestHeader("jwt") String token){
        Optional<UserDetails> userDetailsOptional = this.jwtTokenHandler.parseUserFromToken(token);
        if(userDetailsOptional.isPresent()){
            return ResponseEntity.ok(this.adminService.getAdminInfoWithCheckAdmin(userDetailsOptional.get()));
        }
        return ResponseEntity.ok(new ArrayList<>());
    }


}
