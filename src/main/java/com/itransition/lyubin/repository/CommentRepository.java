package com.itransition.lyubin.repository;

import com.itransition.lyubin.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by User on 11.04.2017.
 */
public interface CommentRepository extends JpaRepository<Comment,Integer> {

    @Query(value = "FROM Comment as i WHERE i.image.id= :id")
    List<Comment> findAllByImageId(@Param("id") Integer id);
}
