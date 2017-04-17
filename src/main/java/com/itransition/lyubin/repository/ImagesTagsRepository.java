package com.itransition.lyubin.repository;

import com.itransition.lyubin.model.ImagesTags;
import com.itransition.lyubin.model.Tag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Created by User on 11.04.2017.
 */
public interface ImagesTagsRepository extends JpaRepository<ImagesTags,Integer> {

    /**
     * @param id of image
     * @return list of tags
     */
    @Query("SELECT it.tag FROM ImagesTags it WHERE it.image.id = :id")
    List<Tag> findAllByImageId(Integer id);
}
