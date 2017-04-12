package com.itransition.lyubin.service.impl;

import com.itransition.lyubin.model.Image;
import com.itransition.lyubin.repository.ImageRepository;
import com.itransition.lyubin.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;


/**
 * Created by User on 12.04.2017.
 */
@Service
@Transactional
public class ImageServiceImpl implements ImageService {

    private ImageRepository imageRepository;

    @Autowired
    public ImageServiceImpl(ImageRepository imageRepository){
        this.imageRepository = imageRepository;
    }

    @Override
    public List<Image> findAllByUserId(Integer id) {
        return this.imageRepository.findAllByUserId(id);
    }

    @Override
    public void save(Image image) {
        this.imageRepository.save(image);
    }

    @Override
    public void delete(Integer id) {
        this.imageRepository.delete(id);
    }
}
