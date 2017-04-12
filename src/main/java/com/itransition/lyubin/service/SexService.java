package com.itransition.lyubin.service;

import com.itransition.lyubin.model.Sex;

/**
 * Created by User on 12.04.2017.
 */
public interface SexService {
    Iterable<Sex> findAll();
    Sex findById(Integer id);
    void save(Sex post);
    void delete(Integer id);
}
