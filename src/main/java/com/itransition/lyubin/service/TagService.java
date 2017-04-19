package com.itransition.lyubin.service;


import com.itransition.lyubin.model.Tag;

import java.util.List;

public interface TagService {
    List<Tag> findAll();
    Tag findById(Integer id);
    List<Tag> findByImageId(Integer id);
    void save(Tag tag);
    void delete(Integer id);
}
