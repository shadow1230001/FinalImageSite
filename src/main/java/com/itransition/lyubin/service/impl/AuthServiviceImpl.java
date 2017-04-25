package com.itransition.lyubin.service.impl;


import com.itransition.lyubin.dto.ImageDTO;
import com.itransition.lyubin.dto.ProfileDTO;
import com.itransition.lyubin.dto.UserDTO;
import com.itransition.lyubin.model.Image;
import com.itransition.lyubin.model.User;
import com.itransition.lyubin.repository.ImageRepository;
import com.itransition.lyubin.repository.RoleRepositiry;
import com.itransition.lyubin.service.AuthService;
import com.itransition.lyubin.service.ProfileService;
import com.itransition.lyubin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
//@Transactional
public class AuthServiviceImpl implements AuthService {

    private UserService userService;
    private ProfileService profileService;
    private RoleRepositiry roleRepositiry;
    private ImageRepository imageRepository;

    @Autowired
    public AuthServiviceImpl(UserService userService, ProfileService profileService,
                             RoleRepositiry roleRepositiry, ImageRepository imageRepository) {
        this.userService = userService;
        this.profileService = profileService;
        this.roleRepositiry = roleRepositiry;
        this.imageRepository = imageRepository;
    }

    @Override
    public boolean login(UserDTO userDTO) {
        User user = userDTO.toUser();
        try {
            this.userService.loadUserByUsername(user.getUsername());
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    @Override
    public boolean singup(UserDTO userDTO, ProfileDTO profileDTO, ImageDTO imageDTO) {
        User user = userDTO.toUser();
        try {
            this.userService.loadUserByUsername(user.getUsername());
        } catch (Exception e) {
            user = this.userService.createUser(userDTO);
            Integer idProfile = saveProfile(user.getId(), profileDTO);
            Image image = imageDTO.toImageWithoutProfile();
            image.setProfile(this.profileService.findById(idProfile));
            this.imageRepository.save(image);
            return true;
        }
        return false;
    }

    private Integer saveProfile(Integer id, ProfileDTO profileDTO) {
        profileDTO.setIdUser(id);
        profileDTO.setColLike(0);
        profileDTO.setRating(0.0);
        return this.profileService.save(profileDTO);
    }

}
