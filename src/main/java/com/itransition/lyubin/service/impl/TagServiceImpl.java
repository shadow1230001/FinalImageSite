package com.itransition.lyubin.service.impl;


import com.itransition.lyubin.model.Tag;
import com.itransition.lyubin.repository.ImagesTagsRepository;
import com.itransition.lyubin.repository.TagRepository;
import com.itransition.lyubin.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class TagServiceImpl implements TagService {

    private TagRepository tagRepository;
    private ImagesTagsRepository imagesTagsRepository;

    @Autowired
    public TagServiceImpl(TagRepository tagRepository, ImagesTagsRepository imagesTagsRepository){
        this.tagRepository = tagRepository;
        this.imagesTagsRepository = imagesTagsRepository;
    }

    @Override
    public List<Tag> findAll() {
        return this.tagRepository.findAll();
    }

    @Override
    public Tag findById(Integer id) {
        return this.tagRepository.findOne(id);
    }

    @Override
    public List<Tag> findByImageId(Integer id) {
        return this.imagesTagsRepository.findAllByImageId(id);
    }

    @Override
    public void save(Tag tag) {
        this.tagRepository.save(tag);
    }

    @Override
    public void delete(Integer id) {
        this.tagRepository.delete(id);
    }
}
