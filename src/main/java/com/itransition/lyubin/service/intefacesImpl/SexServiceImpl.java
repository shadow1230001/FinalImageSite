package com.itransition.lyubin.service.intefacesImpl;

import com.itransition.lyubin.model.Sex;
import com.itransition.lyubin.repository.SexRepository;
import com.itransition.lyubin.service.interfaces.SexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by User on 12.04.2017.
 */
@Service
@Transactional
public class SexServiceImpl implements SexService {

    private SexRepository sexRepository;

    @Autowired
    public SexServiceImpl(SexRepository sexRepository){
        this.sexRepository = sexRepository;
    }

    public List<Sex> findAll() {
        return sexRepository.findAll();
    }

    public Sex findById(Integer id) {
        return sexRepository.findById(id);
    }

    public void save(Sex sex) {
        sexRepository.save(sex);
    }

    public void delete(Integer id) {
        sexRepository.delete(id);
    }
}