package com.itransition.lyubin.controller;

import com.itransition.lyubin.model.Image;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping( value = "/image" )
public class ImageController {

    private ImageService imageService;

    @Autowired
    public ImageController(ImageService imageService){
        this.imageService = imageService;
    }

    //Todo
    @GetMapping( value = "/getfirst" )
    public ResponseEntity<?> getFirstImageByUserId(@RequestParam int id){
        return ResponseEntity.ok("first image");
    }

    @GetMapping( value = "/get" )
    public ResponseEntity<?> getAllByUserId(@RequestParam int id){
        return ResponseEntity.ok(this.imageService.findAllByUserId(id));
    }

    @PostMapping( value = "/save" )
    public ResponseEntity<?> save(@RequestBody Image image){
        this.imageService.save(image);
        return ResponseEntity.ok("ok");
    }

    @PostMapping( value = "/remove" )
    public ResponseEntity<?> remove(@RequestBody int id){
        this.imageService.delete(id);
        return ResponseEntity.ok("ok");
    }

    @PostMapping( value = "/update" )
    public ResponseEntity<?> update(@RequestBody String image){
        return ResponseEntity.ok("update image");
    }

}
