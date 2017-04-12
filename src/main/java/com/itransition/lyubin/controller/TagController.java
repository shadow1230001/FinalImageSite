package com.itransition.lyubin.controller;

import com.itransition.lyubin.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/tags")
public class TagController {

    private TagService tagService;

    @Autowired
    public TagController(TagService tagService) {
        this.tagService = tagService;
    }

    @GetMapping(value = "")
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(this.tagService.findAll());
    }

    @GetMapping(value = "/images/{id}")
    public ResponseEntity<?> getTagsByImageId(@PathVariable Integer id) {
        return ResponseEntity.ok("tags");
    }

}