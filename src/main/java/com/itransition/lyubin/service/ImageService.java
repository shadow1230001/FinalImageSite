package com.itransition.lyubin.service;


import com.itransition.lyubin.dto.ImageDTO;
import com.itransition.lyubin.model.Image;

import java.util.List;

public interface ImageService {
    List<Image> findAllByUserId(Integer id);
    Image findFirstByUserId(Integer id);
    Integer save(ImageDTO imageDTO);
    void delete(Integer id);
}
