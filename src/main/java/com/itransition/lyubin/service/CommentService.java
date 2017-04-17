package com.itransition.lyubin.service;

import com.itransition.lyubin.dto.CommentDTO;
import com.itransition.lyubin.model.Comment;

import java.util.List;

/**
 * Created by User on 12.04.2017.
 */
public interface CommentService {
        List<Comment> findAllByImageId(Integer id);
        void save(CommentDTO commentDTO);
        void delete(Integer id);
}
