package com.itransition.lyubin.service.impl;


import com.itransition.lyubin.model.Sex;
import com.itransition.lyubin.repository.SexRepository;
import com.itransition.lyubin.service.SexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class SexServiceImpl implements SexService {

    private SexRepository sexRepository;

    @Autowired
    public SexServiceImpl(SexRepository sexRepository) {

        this.sexRepository = sexRepository;
    }

    public Iterable<Sex> findAll() {

        return sexRepository.findAll();
    }

    public Sex findById(Integer id) {

        return sexRepository.findOne(id);
    }

    public void save(Sex sex) {

        sexRepository.save(sex);
    }

    public void delete(Integer id) {

        sexRepository.delete(id);
    }
}