package com.itransition.lyubin.service;


import com.itransition.lyubin.dto.ProfileDTO;
import com.itransition.lyubin.model.Profile;
import org.springframework.security.core.userdetails.UserDetails;

public interface ProfileService {
    Profile findByUserId(Integer id);

    Profile findById(Integer id);

    Integer save(ProfileDTO profileDTO);

    void update(ProfileDTO profileDTO, UserDetails userDetails);

    void delete(Integer id);

    Integer findRatingByUserId(Integer id);

    Profile findByUserDetals(UserDetails userDetails);
}
