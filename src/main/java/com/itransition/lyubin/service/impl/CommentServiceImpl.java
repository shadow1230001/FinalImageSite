package com.itransition.lyubin.service.impl;

import com.itransition.lyubin.model.Comment;
import com.itransition.lyubin.repository.CommentRepository;
import com.itransition.lyubin.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by User on 12.04.2017.
 */
@Service
@Transactional
public class CommentServiceImpl implements CommentService {

    private CommentRepository commentRepository;

    @Autowired
    public CommentServiceImpl(CommentRepository commentRepository){
        this.commentRepository = commentRepository;
    }

    @Override
    public List<Comment> findAllByImageId(Integer id) {
        return this.commentRepository.findAllByImageId(id);
    }

    @Override
    public void save(Comment comment) {
        this.commentRepository.save(comment);
    }

    @Override
    public void delete(Integer id) {
        this.commentRepository.delete(id);
    }
}
