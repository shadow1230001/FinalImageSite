package com.itransition.lyubin.service.impl;

import com.itransition.lyubin.dto.ProfileDTO;
import com.itransition.lyubin.model.Profile;
import com.itransition.lyubin.repository.ProfileRepository;
import com.itransition.lyubin.repository.SexRepository;
import com.itransition.lyubin.repository.TypeOfPhotographyRepository;
import com.itransition.lyubin.repository.UserRepository;
import com.itransition.lyubin.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class ProfileServiceImpl implements ProfileService {

    private ProfileRepository profileRepository;
    private UserRepository userRepository;
    private SexRepository sexRepository;
    private TypeOfPhotographyRepository typeOfPhotographyRepository;

    @Autowired
    public ProfileServiceImpl(ProfileRepository profileRepository, UserRepository userRepository,
                              SexRepository sexRepository, TypeOfPhotographyRepository typeOfPhotographyRepository){
        this.profileRepository = profileRepository;
        this.userRepository = userRepository;
        this.sexRepository = sexRepository;
        this.typeOfPhotographyRepository = typeOfPhotographyRepository;
    }

    @Override
    public Profile findByUserId(Integer id) {
        return this.profileRepository.findByUserId(id);
    }

    @Override
    public Profile findById(Integer id) {
        return this.profileRepository.findById(id);
    }

    @Override
    public Integer save(ProfileDTO profileDTO) {
        Profile profile = profileDTO.toProfileWithoutUserSexTypeOfPhotography();
        profile.setUser(this.userRepository.findOne(profileDTO.getIdUser()));
        profile.setSex(this.sexRepository.findOne(profileDTO.getIdSex()));
        profile.setTypeOfPhotography(this.typeOfPhotographyRepository.findOne(profileDTO.getIdTypeOfPhotography()));
        this.profileRepository.save(profile);
        return this.profileRepository.findByUserId(profile.getUser().getId()).getId();
    }

    @Override
    public void delete(Integer id) {
        this.profileRepository.delete(id);
    }

    @Override
    public Integer findRatingByUserId(Integer id) {
        return this.profileRepository.findRatingByUserId(id);
    }

}
