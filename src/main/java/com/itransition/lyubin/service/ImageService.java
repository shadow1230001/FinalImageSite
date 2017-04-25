package com.itransition.lyubin.service;


import com.itransition.lyubin.dto.ImageDTO;
import com.itransition.lyubin.model.Image;

import java.util.List;

public interface ImageService {
    List<Image> findAllByProfileId(Integer id);

    Image findFirstByUserId(Integer id);

    Integer save(ImageDTO imageDTO);

    Integer saveNext(ImageDTO imageDTO);

    void delete(Integer id);
}