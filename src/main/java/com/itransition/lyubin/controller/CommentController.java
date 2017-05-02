package com.itransition.lyubin.controller;


import com.itransition.lyubin.dto.CommentDTO;
import com.itransition.lyubin.security.JwtTokenHandler;
import com.itransition.lyubin.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping(value = "/comments")
public class CommentController {

    private CommentService commentService;
    private JwtTokenHandler jwtTokenHandler;

    @Autowired
    public CommentController(CommentService commentService, JwtTokenHandler jwtTokenHandler) {
        this.commentService = commentService;
        this.jwtTokenHandler = jwtTokenHandler;
    }

    @GetMapping(value = "/getAll/{id}")
    public ResponseEntity<?> getCommentsByImageId(@PathVariable Integer id) {
        return ResponseEntity.ok(this.commentService.findAllByImageId(id));
    }

    @GetMapping(value = "/getAll")
    public ResponseEntity<?> getAllComments() {
        return ResponseEntity.ok(this.commentService.findAll());
    }

    @PostMapping(value = "/save")
    public ResponseEntity<?> save(@RequestBody CommentDTO commentDTO) {
        this.commentService.save(commentDTO);
        return ResponseEntity.ok("ok");
    }

    @PostMapping(value = "/savenaxt")
    public ResponseEntity<?> saveNext(@RequestBody CommentDTO commentDTO,
                                      @RequestHeader(value = "jwt") String token) {
        Optional<UserDetails> userDetailsOptional = null;
        if (!token.equals("")) {
            userDetailsOptional = this.jwtTokenHandler.parseUserFromToken(token);
            this.commentService.saveNext(commentDTO, userDetailsOptional.get());
        } else {
            this.commentService.saveNext(commentDTO, null);
        }
        return ResponseEntity.ok("ok");
    }
}