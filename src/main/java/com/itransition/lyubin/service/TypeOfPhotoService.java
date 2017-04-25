package com.itransition.lyubin.service;


import com.itransition.lyubin.model.TypeOfPhotography;

public interface TypeOfPhotoService {
    Iterable<TypeOfPhotography> findAll();

    TypeOfPhotography findById(Integer id);

    void save(TypeOfPhotography typeOfPhotography);

    void delete(Integer id);
}
