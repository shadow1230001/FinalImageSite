package com.itransition.lyubin.repository;

import com.itransition.lyubin.model.Comment;
import com.itransition.lyubin.model.Image;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by User on 11.04.2017.
 */
public interface CommentRepository extends JpaRepository<Comment, Integer> {

    List<Comment> findByImage(Image image);

    List<Comment> findAllByImageId(Integer id);
}
