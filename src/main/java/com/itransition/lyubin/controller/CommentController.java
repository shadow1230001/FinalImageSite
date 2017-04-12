package com.itransition.lyubin.controller;

import com.itransition.lyubin.model.Comment;
import com.itransition.lyubin.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/comments")
public class CommentController {

    private CommentService commentService;

    @Autowired
    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @GetMapping(value = "/images/{id}")
    public ResponseEntity<?> getCommentsByImageId(@PathVariable Integer id) {
        return ResponseEntity.ok(this.commentService.findAllByImageId(id));
    }

    @PostMapping(value = "/save")
    public ResponseEntity<?> save(@RequestBody Comment comment) {
        this.commentService.save(comment);
        return ResponseEntity.ok("ok");
    }

}