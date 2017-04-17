package com.itransition.lyubin.service.impl;

import com.itransition.lyubin.dto.ImageDTO;
import com.itransition.lyubin.model.Image;
import com.itransition.lyubin.repository.ImageRepository;
import com.itransition.lyubin.repository.UserRepository;
import com.itransition.lyubin.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by User on 12.04.2017.
 */
@Service
@Transactional
public class ImageServiceImpl implements ImageService {

    private ImageRepository imageRepository;

    private UserRepository userRepository;

    @Autowired
    public ImageServiceImpl(ImageRepository imageRepository, UserRepository userRepository){
        this.imageRepository = imageRepository;
        this.userRepository = userRepository;
    }

    @Override
    public List<Image> findAllByUserId(Integer id) {
        return this.imageRepository.findAllByUserId(id);
    }

    @Override
    public Image findFirstByUserId(Integer id) {
        return this.imageRepository.findByIdUserInPosition1(id);
    }

    @Override
    public void save(ImageDTO imageDTO) {
        Image image = imageDTO.toImageWithoutUser();
        image.setUser(this.userRepository.findOne(imageDTO.getIdImage()));
        this.imageRepository.save(image);
    }

    @Override
    public void delete(Integer id) {
        this.imageRepository.delete(id);
    }
}