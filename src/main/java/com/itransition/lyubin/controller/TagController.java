package com.itransition.lyubin.controller;


import com.itransition.lyubin.model.Tag;
import com.itransition.lyubin.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/tags")
public class TagController {

    private TagService tagService;

    @Autowired
    public TagController(TagService tagService) {
        this.tagService = tagService;
    }

    @GetMapping(value = "/getAll")
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(this.tagService.findAll());
    }

    @GetMapping(value = "/images/{id}")
    public ResponseEntity<?> getTagsByImageId(@PathVariable Integer id) {
        return ResponseEntity.ok(this.tagService.findByImageId(id));
    }

    @PostMapping(value = "/images/save")
    public ResponseEntity<?> saveTag(@RequestBody Tag tag) {
        this.tagService.save(tag);
        return ResponseEntity.ok("ok");
    }

}