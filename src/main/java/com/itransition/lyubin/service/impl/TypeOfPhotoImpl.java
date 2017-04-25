package com.itransition.lyubin.service.impl;


import com.itransition.lyubin.model.TypeOfPhotography;
import com.itransition.lyubin.repository.TypeOfPhotographyRepository;
import com.itransition.lyubin.service.TypeOfPhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TypeOfPhotoImpl implements TypeOfPhotoService {

    private TypeOfPhotographyRepository typeOfPhotographyRepository;

    @Autowired
    public TypeOfPhotoImpl(TypeOfPhotographyRepository typeOfPhotographyRepository){
        this.typeOfPhotographyRepository = typeOfPhotographyRepository;
    }

    @Override
    public Iterable<TypeOfPhotography> findAll() {
        return this.typeOfPhotographyRepository.findAll();
    }

    @Override
    public TypeOfPhotography findById(Integer id) {
        return this.typeOfPhotographyRepository.findOne(id);
    }

    @Override
    public void save(TypeOfPhotography typeOfPhotography) {
        this.typeOfPhotographyRepository.save(typeOfPhotography);
    }

    @Override
    public void delete(Integer id) {
        this.typeOfPhotographyRepository.delete(id);
    }

}
