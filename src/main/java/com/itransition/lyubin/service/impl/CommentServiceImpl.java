package com.itransition.lyubin.service.impl;

import com.itransition.lyubin.dto.CommentDTO;
import com.itransition.lyubin.model.Comment;
import com.itransition.lyubin.model.Profile;
import com.itransition.lyubin.repository.CommentRepository;
import com.itransition.lyubin.repository.ImageRepository;
import com.itransition.lyubin.repository.ProfileRepository;
import com.itransition.lyubin.repository.UserRepository;
import com.itransition.lyubin.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class CommentServiceImpl implements CommentService {

    private CommentRepository commentRepository;

    private ImageRepository imageRepository;

    private UserRepository userRepository;

    private ProfileRepository profileRepository;

    @Autowired
    public CommentServiceImpl(CommentRepository commentRepository, ImageRepository imageRepository,
                              UserRepository userRepository, ProfileRepository profileRepository) {
        this.commentRepository = commentRepository;
        this.imageRepository = imageRepository;
        this.userRepository = userRepository;
        this.profileRepository = profileRepository;
    }

    @Override
    public List<Comment> findAllByImageId(Integer id) {
        List<Comment> commentList = this.commentRepository.findAllByImageId(id);

        return commentList;
    }

    @Override
    public List<Comment> findAll() {

        return this.commentRepository.findAll();
    }

    @Override
    public void save(CommentDTO commentDTO) {
        Comment comment = commentDTO.toCommentWithoutImage();
        comment.setImage(this.imageRepository.findOne(commentDTO.getImageId()));

        this.commentRepository.save(comment);
    }

    @Override
    public void saveNext(CommentDTO commentDTO, UserDetails userDetails) {
        Comment comment = commentDTO.toCommentWithoutImage();
        if (userDetails != null) {
            Profile profile = this.profileRepository
                    .findByUser(this.userRepository.findByLogin(userDetails.getUsername()));
            comment.setTitle(profile.getName());
        } else comment.setTitle("anonimus");
        comment.setImage(this.imageRepository.findOne(commentDTO.getImageId()));
        Integer pozition = this.commentRepository.findCommentWhereMaxPosition(commentDTO.getImageId());
        if (pozition == null) pozition = 0;//lol
        comment.setPosition(pozition + 1);

        this.commentRepository.save(comment);
    }

    @Override
    public void delete(Integer id) {

        this.commentRepository.delete(id);
    }
}