package com.itransition.lyubin.controller;

import com.itransition.lyubin.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/profiles")
public class ProfileController {

    private ProfileService profileService;

    @Autowired
    public ProfileController(ProfileService profileService) {
        this.profileService = profileService;
    }

    @GetMapping(value = "/users/{id}")
    public ResponseEntity<?> getProfileByUserId(@PathVariable Integer id) {
        return ResponseEntity.ok(this.profileService.findByUserId(id));
    }

    @GetMapping(value = "/rating")
    public ResponseEntity<?> getRatingById(@RequestParam int id) {
        return ResponseEntity.ok("rating");
    }

}
