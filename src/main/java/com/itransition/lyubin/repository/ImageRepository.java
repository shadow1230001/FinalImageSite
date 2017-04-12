package com.itransition.lyubin.repository;

import com.itransition.lyubin.model.Image;
import com.itransition.lyubin.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by User on 11.04.2017.
 */
public interface ImageRepository extends JpaRepository<Image, Integer> {

    List<Image> findByUser(User user);

    List<Image> findAllByUserId(Integer id);
}
