package com.itransition.lyubin.service.interfaces;

import com.itransition.lyubin.model.Sex;

import java.util.List;

/**
 * Created by User on 12.04.2017.
 */
public interface SexService {
    List<Sex> findAll();
    Sex findById(Integer id);
    void save(Sex post);
    void delete(Integer id);
}
