package com.itransition.lyubin.service;

import com.itransition.lyubin.dto.UserDTO;
import com.itransition.lyubin.model.User;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 * Created by User on 12.04.2017.
 */
public interface UserService  extends UserDetailsService {
    Iterable<User> findAll();
    User findById(Integer id);
    void save(User user);
    void delete(Integer id);
    User createUser(UserDTO userDTO);
}
