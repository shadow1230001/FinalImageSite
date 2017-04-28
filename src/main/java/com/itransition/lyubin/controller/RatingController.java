package com.itransition.lyubin.controller;

import com.itransition.lyubin.dto.AddRatingInfoDTO;
import com.itransition.lyubin.security.JwtTokenHandler;
import com.itransition.lyubin.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping(value = "rating")
public class RatingController {

    private JwtTokenHandler jwtTokenHandler;
    private RatingService ratingService;

    @Autowired
    public RatingController(JwtTokenHandler jwtTokenHandler, RatingService ratingService) {
        this.jwtTokenHandler = jwtTokenHandler;
        this.ratingService = ratingService;
    }

    @PostMapping(value = "add")
    public ResponseEntity<?> addLike(@RequestBody AddRatingInfoDTO addRatingInfoDTO,
                                     @RequestHeader("jwt") String jwt){
        UserDetails userDetails = this.jwtTokenHandler.parseUserFromToken(jwt).get();
        this.ratingService.addRating(addRatingInfoDTO, userDetails);
        return ResponseEntity.ok("ok");
    }
}
