package com.itransition.lyubin.service;

import com.itransition.lyubin.model.User;

/**
 * Created by User on 12.04.2017.
 */
public interface UserService {
    Iterable<User> findAll();
    User findById(Integer id);
    void save(User user);
    void delete(Integer id);
}
