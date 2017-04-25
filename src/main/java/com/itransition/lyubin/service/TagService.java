package com.itransition.lyubin.service;

import com.itransition.lyubin.dto.TagDTO;
import com.itransition.lyubin.model.Tag;

import java.util.List;

public interface TagService {
    List<Tag> findAll();

    Tag findById(Integer id);

    List<Tag> findByImageId(Integer id);

    void save(TagDTO tagDTO);

    void saveAll(List<TagDTO> tags);

    void delete(Integer id);
}