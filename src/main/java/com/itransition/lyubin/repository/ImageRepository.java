package com.itransition.lyubin.repository;

import com.itransition.lyubin.model.Image;
import com.itransition.lyubin.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by User on 11.04.2017.
 */
public interface ImageRepository extends JpaRepository<Image, Integer> {

    List<Image> findByUser(User user);

    List<Image> findAllByProfileId(Integer id);

    @Query("SELECT i FROM Image as i WHERE i.position = 1 AND i.profile.id = :id")
    Image findByIdProfileInPosition1(@Param("id") Integer id);
}
