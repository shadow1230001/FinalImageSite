package com.itransition.lyubin.controller;


import com.itransition.lyubin.dto.ProfileDTO;
import com.itransition.lyubin.security.JwtTokenHandler;
import com.itransition.lyubin.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping(value = "/profiles")
public class ProfileController {

    private ProfileService profileService;
    private JwtTokenHandler jwtTokenHandler;

    @Autowired
    public ProfileController(ProfileService profileService, JwtTokenHandler jwtTokenHandler) {
        this.profileService = profileService;
        this.jwtTokenHandler = jwtTokenHandler;
    }

    @PostMapping(value = "update")
    public ResponseEntity<?> updateProfile(@RequestHeader(value = "jwt") String jwt,
                                           @RequestBody ProfileDTO profileDTO){
        java.util.Optional<UserDetails> userDetailsOptional = this.jwtTokenHandler.parseUserFromToken(jwt);
        userDetailsOptional.ifPresent(userDetails -> this.profileService.update(profileDTO, userDetails));
        return ResponseEntity.ok("ok");
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
    @GetMapping(value = "getMyProfileId")
    public ResponseEntity<?> getMyProfileId(@RequestHeader(value = "jwt") String jwt) {
        UserDetails userDetails = this.jwtTokenHandler.parseUserFromToken(jwt).get();
        return ResponseEntity.ok(this.profileService.findByUserDetals(userDetails).getId());
    }
}
