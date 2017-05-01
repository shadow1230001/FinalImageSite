package com.itransition.lyubin.service.impl;

import com.itransition.lyubin.model.Profile;
import com.itransition.lyubin.model.Role;
import com.itransition.lyubin.model.User;
import com.itransition.lyubin.model.notdbmodel.UserInfoForAdmin;
import com.itransition.lyubin.repository.ProfileRepository;
import com.itransition.lyubin.repository.UserRepository;
import com.itransition.lyubin.repository.UsersRolesRepository;
import com.itransition.lyubin.service.AdminService;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Service
public class AdminServiceImpl implements AdminService {

    private ProfileRepository profileRepository;
    private UserRepository userRepository;
    private UsersRolesRepository usersRolesRepository;

    @Autowired
    public AdminServiceImpl(ProfileRepository profileRepository, UserRepository userRepository,
                            UsersRolesRepository usersRolesRepository) {
        this.profileRepository = profileRepository;
        this.userRepository = userRepository;
        this.usersRolesRepository = usersRolesRepository;
    }

    @Override
    public List<UserInfoForAdmin> getAdminInfo() {
        List<User> users = this.userRepository.findAll();
        List<UserInfoForAdmin> userInfoForAdminList = new ArrayList();
        for (User user : users) {
            userInfoForAdminList.add(this.create(user));
        }
        return userInfoForAdminList;
    }

    @Override
    public List<UserInfoForAdmin> getAdminInfoWithCheckAdmin(UserDetails userDetails) {
        User user = this.userRepository.findByLogin(userDetails.getUsername());
        Role role = this.usersRolesRepository.getUsersRolesByUser(user).getRole();
        if(role.getRolename().equals("ROLE_ADMIN")){
            return this. getAdminInfo();
        }
        return new ArrayList();
    }

    private UserInfoForAdmin create(User user) {
        Profile profile = this.profileRepository.findByUser(user);
        Role role = this.usersRolesRepository.getUsersRolesByUser(user).getRole();
        return new UserInfoForAdmin(user.getId(), profile.getName(), profile.getColLike(), profile.getRating(), role);
    }

}
