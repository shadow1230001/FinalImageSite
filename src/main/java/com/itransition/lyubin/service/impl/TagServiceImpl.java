package com.itransition.lyubin.service.impl;


import com.itransition.lyubin.dto.TagDTO;
import com.itransition.lyubin.model.ImagesTags;
import com.itransition.lyubin.model.Tag;
import com.itransition.lyubin.repository.ImageRepository;
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
    private ImageRepository imageRepository;

    @Autowired
    public TagServiceImpl(TagRepository tagRepository, ImagesTagsRepository imagesTagsRepository,
                          ImageRepository imageRepository){
        this.tagRepository = tagRepository;
        this.imagesTagsRepository = imagesTagsRepository;
        this.imageRepository = imageRepository;
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
    public void save(TagDTO tagDTO) {
        Tag tag = tagDTO.toTag();
        tag = this.tagRepository.save(tag);
        ImagesTags imagesTags = tagDTO.getEmptyImagesTags();
        imagesTags.setImage(this.imageRepository.findOne(tagDTO.getIdImage()));
        imagesTags.setTag(tag);
        this.imagesTagsRepository.save(imagesTags);
    }

    @Override
    public void saveAll(List<TagDTO> tagsDTO) {
        for(int i = 0; i < tagsDTO.size(); i++ ){
            this.save(tagsDTO.get(i));
        }
    }

    @Override
    public void delete(Integer id) {
        this.tagRepository.delete(id);
    }
}