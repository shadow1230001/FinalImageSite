package com.itransition.lyubin.controller;

import com.itransition.lyubin.model.Sex;
import com.itransition.lyubin.repository.SexRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(value = "/sex")
public class SexController {

    @Autowired
    private SexRepository sexRepository;

    @GetMapping(value = "/getsex")
    public ResponseEntity<?> getAllSex() {
        return ResponseEntity.ok("tags");
    }

    @GetMapping(value = "/sex")
    public ResponseEntity<?> getSexByImageId(@RequestParam int id) {
        return ResponseEntity.ok("tags");
    }

    @PostMapping(value = "/add")
    public ResponseEntity<?> addSex (@RequestBody Sex sex){
        return ResponseEntity.ok("sex");
    }
}
