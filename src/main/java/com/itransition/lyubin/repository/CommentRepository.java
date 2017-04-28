package com.itransition.lyubin.repository;

import com.itransition.lyubin.model.Comment;
import com.itransition.lyubin.model.Image;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Integer> {

    List<Comment> findByImage(Image image);

    List<Comment> findAllByImageId(Integer id);

    @Query("SELECT max(c.position) FROM Comment as c WHERE c.image.id=:id")
    Integer findCommentWhereMaxPosition(@Param("id") Integer id);
}