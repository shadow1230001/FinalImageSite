package com.itransition.lyubin.service;


import com.itransition.lyubin.dto.UserDTO;
import com.itransition.lyubin.model.User;

public interface UserService {
    Iterable<User> findAll();
    User findById(Integer id);
    void save(User user);
    void delete(Integer id);
    void createUser(UserDTO userDTO);
}
