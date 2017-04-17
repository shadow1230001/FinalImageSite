package com.itransition.lyubin.controller;

import com.itransition.lyubin.dto.ProfileDTO;
import com.itransition.lyubin.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/profiles")
public class ProfileController {

    private ProfileService profileService;

    @Autowired
    public ProfileController(ProfileService profileService) {
        this.profileService = profileService;
    }

    @PostMapping(value = "create")
    public ResponseEntity<?> create(@RequestBody ProfileDTO profileDTO) {
        return ResponseEntity.ok(this.profileService.save(profileDTO));
    }

    @GetMapping(value = "get/{id}")
    public ResponseEntity<?> getProfileById(@PathVariable Integer id) {
        return ResponseEntity.ok(this.profileService.findById(id));
    }

    @GetMapping(value = "get/user/{id}")
    public ResponseEntity<?> getProfileByUserId(@PathVariable Integer id) {
        return ResponseEntity.ok(this.profileService.findByUserId(id));
    }

    @GetMapping(value = "/rating/{id}")
    public ResponseEntity<?> getRatingById(@PathVariable int id) {
        return ResponseEntity.ok(this.profileService.findByUserId(id).getRating());
    }

}