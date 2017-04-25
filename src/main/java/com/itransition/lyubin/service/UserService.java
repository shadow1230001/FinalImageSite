package com.itransition.lyubin.service;


import com.itransition.lyubin.dto.UserDTO;
import com.itransition.lyubin.model.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.Optional;

public interface UserService extends UserDetailsService {
    Iterable<User> findAll();

    User findById(Integer id);

    Optional<User> findUser(Integer id);

    User save(User user);

    void delete(Integer id);

    User createUser(UserDTO userDTO);
}