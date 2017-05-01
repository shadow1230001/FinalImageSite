package com.itransition.lyubin.service;


import com.itransition.lyubin.dto.CommentDTO;
import com.itransition.lyubin.model.Comment;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;

public interface CommentService {
    List<Comment> findAllByImageId(Integer id);

    List<Comment> findAll();

    void save(CommentDTO commentDTO);

    void saveNext(CommentDTO commentDTO, UserDetails userDetails);

    void delete(Integer id);
}