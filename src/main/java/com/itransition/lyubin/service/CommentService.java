package com.itransition.lyubin.service;


import com.itransition.lyubin.dto.CommentDTO;
import com.itransition.lyubin.model.Comment;

import java.util.List;

public interface CommentService {
    List<Comment> findAllByImageId(Integer id);


    void save(CommentDTO commentDTO);

    void delete(Integer id);
}
