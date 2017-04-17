package com.itransition.lyubin.service;

import com.itransition.lyubin.dto.ImageDTO;
import com.itransition.lyubin.model.Image;

import java.util.List;

/**
 * Created by User on 12.04.2017.
 */
public interface ImageService {
    List<Image> findAllByUserId(Integer id);

    Image findFirstByUserId(Integer id);

    void save(ImageDTO imageDTO);
    void delete(Integer id);
}
