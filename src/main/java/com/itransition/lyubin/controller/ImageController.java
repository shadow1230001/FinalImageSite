package com.itransition.lyubin.controller;

import com.itransition.lyubin.dto.ImageDTO;
import com.itransition.lyubin.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping(value = "/images")
public class ImageController {

    private ImageService imageService;

    @Autowired
    public ImageController(ImageService imageService) {
        this.imageService = imageService;
    }

    @GetMapping(value = "/getfirst/{id}")
    public ResponseEntity<?> getFirstImageByUserId(@PathVariable(value = "id") Integer id) {
        return ResponseEntity.ok(this.imageService.findFirstByUserId(id));
    }

    @GetMapping(value = "/getAll/{id}")
    public ResponseEntity<?> getAllByUserId(@PathVariable(value = "id") Integer id) {
        return ResponseEntity.ok(this.imageService.findAllByUserId(id));
    }

    @PostMapping(value = "/save")
    public ResponseEntity<?> save(@RequestBody ImageDTO imageDTO) {
        this.imageService.save(imageDTO);
        return ResponseEntity.ok("ok");
    }

    @GetMapping(value = "/delete/{id}")
    public ResponseEntity<?> remove(@PathVariable(value = "id") Integer id) {
        this.imageService.delete(id);
        return ResponseEntity.ok("ok");
    }

}