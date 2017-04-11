package com.itransition.lyubin.repository;

import com.itransition.lyubin.model.Image;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Created by User on 11.04.2017.
 */
public interface ImageRepository extends JpaRepository<Image,Integer> {

    @Query(value = "SELECT i FROM i Image i WHERE i.user.id=?1")
    List<Image> findAllByUserId(Integer id);
}
