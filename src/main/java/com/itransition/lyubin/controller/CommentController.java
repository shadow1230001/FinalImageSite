package com.itransition.lyubin.controller;

import com.itransition.lyubin.model.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping( value = "/comment" )
public class CommentController {

    private CommentService commentService;

    @Autowired
    public CommentController(CommentService commentService){
        this.commentService = commentService;
    }

    @GetMapping( value = "/get")
    public ResponseEntity<?> getCommentsByImageId(@RequestParam int id){
        return ResponseEntity.ok(this.commentService.findAllByImageId(id));
    }

    @PostMapping( value = "/save" )
    public ResponseEntity<?> save(@RequestBody Comment comment){
        this.commentService.save(comment);
        return ResponseEntity.ok("ok");
    }

}