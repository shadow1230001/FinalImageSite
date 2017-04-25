package com.itransition.lyubin.service;


import com.itransition.lyubin.dto.ProfileDTO;
import com.itransition.lyubin.model.Profile;

public interface ProfileService {
    Profile findByUserId(Integer id);

    Profile findById(Integer id);

    Integer save(ProfileDTO profileDTO);

    void delete(Integer id);

    Integer findRatingByUserId(Integer id);
}
