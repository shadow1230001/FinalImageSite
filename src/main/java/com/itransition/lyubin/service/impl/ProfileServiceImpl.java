package com.itransition.lyubin.service.impl;

import com.itransition.lyubin.model.Profile;
import com.itransition.lyubin.repository.ProfileRepository;
import com.itransition.lyubin.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * Created by User on 12.04.2017.
 */
@Service
@Transactional
public class ProfileServiceImpl implements ProfileService {

    private ProfileRepository profileRepository;

    @Autowired
    public ProfileServiceImpl(ProfileRepository profileRepository){
        this.profileRepository = profileRepository;
    }

    @Override
    public Profile findByUserId(Integer id) {
        return this.profileRepository.findByUserId(id);
    }

    @Override
    public void save(Profile profile) {
        this.profileRepository.save(profile);
    }

    @Override
    public void delete(Integer id) {
        this.profileRepository.delete(id);
    }
}
