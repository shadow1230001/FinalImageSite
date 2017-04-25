package com.itransition.lyubin.service.impl;

import com.itransition.lyubin.dto.CommentDTO;
import com.itransition.lyubin.model.Comment;
import com.itransition.lyubin.repository.CommentRepository;
import com.itransition.lyubin.repository.ImageRepository;
import com.itransition.lyubin.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class CommentServiceImpl implements CommentService {

    private CommentRepository commentRepository;

    private ImageRepository imageRepository;

    @Autowired
    public CommentServiceImpl(CommentRepository commentRepository, ImageRepository imageRepository) {
        this.commentRepository = commentRepository;
        this.imageRepository = imageRepository;
    }

    @Override
    public List<Comment> findAllByImageId(Integer id) {
        return this.commentRepository.findAllByImageId(id);
    }

    @Override
    public void save(CommentDTO commentDTO) {
        Comment comment = commentDTO.toCommentWithoutImage();
        comment.setImage(this.imageRepository.findOne(commentDTO.getImageId()));
        this.commentRepository.save(comment);
    }

    @Override
    public void delete(Integer id) {
        this.commentRepository.delete(id);
    }
}
