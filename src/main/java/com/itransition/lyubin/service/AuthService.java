package com.itransition.lyubin.service;


import com.itransition.lyubin.dto.ImageDTO;
import com.itransition.lyubin.dto.ProfileDTO;
import com.itransition.lyubin.dto.UserDTO;

public interface AuthService {

    boolean login(UserDTO userDTO);

    boolean singup(UserDTO userDTO, ProfileDTO profileDTO, ImageDTO imageDTO);

}
