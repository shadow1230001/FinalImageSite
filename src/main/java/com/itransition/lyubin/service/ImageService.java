package com.itransition.lyubin.service;

import com.itransition.lyubin.model.Image;

import java.util.List;

/**
 * Created by User on 12.04.2017.
 */
public interface ImageService {
    List<Image> findAllByUserId(Integer id);
    void save(Image image);
    void delete(Integer id);
}
