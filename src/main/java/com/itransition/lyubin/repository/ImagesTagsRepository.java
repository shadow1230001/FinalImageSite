package com.itransition.lyubin.repository;


import com.itransition.lyubin.model.ImagesTags;
import com.itransition.lyubin.model.Tag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ImagesTagsRepository extends JpaRepository<ImagesTags, Integer> {

    @Query("SELECT it.tag FROM ImagesTags it WHERE it.image.id = :id")
    List<Tag> findAllByImageId(@Param("id") Integer id);

}