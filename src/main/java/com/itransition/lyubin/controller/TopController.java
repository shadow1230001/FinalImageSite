package com.itransition.lyubin.controller;


import com.itransition.lyubin.service.TopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping(value = "/top")
public class TopController {

    private TopService topService;

    @Autowired
    public TopController(TopService topService) {
        this.topService = topService;
    }

    @GetMapping(value = "/get/{col}")
    public ResponseEntity<?> getAll(@PathVariable Integer col) {
        return ResponseEntity.ok(this.topService.findTop(col));
    }

}
