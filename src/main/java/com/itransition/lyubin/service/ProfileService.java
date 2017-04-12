package com.itransition.lyubin.service;

import com.itransition.lyubin.model.Profile;

/**
 * Created by User on 12.04.2017.
 */
public interface ProfileService {
    Profile findByUserId(Integer id);
    void save(Profile profile);
    void delete(Integer id);
}
