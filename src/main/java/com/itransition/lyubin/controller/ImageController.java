package com.itransition.lyubin.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping( value = "/image" )
public class ImageController {

    @GetMapping( value = "/getfirst" )
    public ResponseEntity<?> getFirstImageByProfileId(@RequestParam int id){
        return ResponseEntity.ok("first image");
    }

    @GetMapping( value = "/get" )
    public ResponseEntity<?> getImagesByProfileId(@RequestParam int id){
        return ResponseEntity.ok("images");
    }

    @PostMapping( value = "/add" )
    public ResponseEntity<?> addImage(@RequestBody String image){
        return ResponseEntity.ok("add image");
    }

    @PostMapping( value = "/remove" )
    public ResponseEntity<?> removeImage(@RequestBody String image){
        return ResponseEntity.ok("remove image");
    }

    @PostMapping( value = "/update" )
    public ResponseEntity<?> updateImage(@RequestBody String image){
        return ResponseEntity.ok("update image");
    }

}
