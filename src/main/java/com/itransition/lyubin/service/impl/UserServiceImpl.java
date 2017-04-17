package com.itransition.lyubin.service.impl;

import com.itransition.lyubin.dto.UserDTO;
import com.itransition.lyubin.model.User;
import com.itransition.lyubin.model.UsersRoles;
import com.itransition.lyubin.repository.RoleRepository;
import com.itransition.lyubin.repository.UserRepository;
import com.itransition.lyubin.repository.UsersRolesRepository;
import com.itransition.lyubin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * Created by User on 12.04.2017.
 */
@Service
@Transactional
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    private UsersRolesRepository usersRolesRepository;
    private RoleRepository roleRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, UsersRolesRepository usersRolesRepository, RoleRepository roleRepository){
        this.userRepository = userRepository;
        this.usersRolesRepository = usersRolesRepository;
        this.roleRepository = roleRepository;
    }

    @Override
    public Iterable<User> findAll() {
        return this.userRepository.findAll();
    }

    @Override
    public User findById(Integer id) {
        return this.userRepository.findOne(id);
    }

    @Override
    public void save(User user) {
        this.userRepository.save(user);
    }

    @Override
    public void delete(Integer id) {
        this.userRepository.delete(id);
    }

    @Override
    public void createUser(UserDTO userDTO) {
        User user = userDTO.toUser();
        user = userRepository.save(user);
        this.usersRolesRepository.save(new UsersRoles(user, this.roleRepository.getOne(1)));
    }
}
