package com.itransition.lyubin.controller;


import com.itransition.lyubin.dto.ArrayImagesDTO;
import com.itransition.lyubin.dto.ImageDTO;
import com.itransition.lyubin.security.JwtTokenHandler;
import com.itransition.lyubin.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping(value = "/images")
public class ImageController {

    private ImageService imageService;
    private JwtTokenHandler jwtTokenHandler;

    @Autowired
    public ImageController(ImageService imageService, JwtTokenHandler jwtTokenHandler) {
        this.imageService = imageService;
        this.jwtTokenHandler = jwtTokenHandler;
    }

    @GetMapping(value = "/getfirst/{id}")
    public ResponseEntity<?> getFirstImageByUserId(@PathVariable(value = "id") Integer id) {
        return ResponseEntity.ok(this.imageService.findFirstByUserId(id));
    }

    @GetMapping(value = "/getAll/{id}")
    public ResponseEntity<?> getAllByUserId(@PathVariable(value = "id") Integer id) {
        return ResponseEntity.ok(this.imageService.findAllByProfileId(id));
    }

    @PostMapping(value = "/save")
    public ResponseEntity<?> save(@RequestBody ImageDTO imageDTO) {
        Integer id = this.imageService.save(imageDTO);
        return ResponseEntity.ok(id);
    }

    @PostMapping(value = "/save/next")
    public ResponseEntity<?> saveNext(@RequestBody ImageDTO imageDTO) {
        Integer id = this.imageService.saveNext(imageDTO);
        return ResponseEntity.ok(id);
    }

    @GetMapping(value = "/delete/{id}")
    public ResponseEntity<?> remove(@PathVariable(value = "id") Integer id) {
        this.imageService.delete(id);
        return ResponseEntity.ok("ok");
    }

    @PostMapping(value = "/saveall")
    public ResponseEntity<?> saveAll(@RequestBody ArrayImagesDTO arrayImagesDTO) {
        this.imageService.saveAll(arrayImagesDTO);
        return ResponseEntity.ok("ok");
    }

}