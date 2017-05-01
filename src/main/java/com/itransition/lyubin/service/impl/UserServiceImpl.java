package com.itransition.lyubin.service.impl;


import com.itransition.lyubin.dto.UserDTO;
import com.itransition.lyubin.model.User;
import com.itransition.lyubin.model.UsersRoles;
import com.itransition.lyubin.repository.RoleRepositiry;
import com.itransition.lyubin.repository.UserRepository;
import com.itransition.lyubin.repository.UsersRolesRepository;
import com.itransition.lyubin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AccountStatusUserDetailsChecker;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    private UsersRolesRepository usersRolesRepository;
    private RoleRepositiry roleRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, UsersRolesRepository usersRolesRepository, RoleRepositiry roleRepository) {
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
    public Optional<User> findUser(Integer id) {
        return Optional.of(userRepository.findOne(id));
    }

    @Override
    public User save(User user) {
        return this.userRepository.save(user);
    }

    @Override
    public void delete(Integer id) {
        this.userRepository.delete(id);
    }

    @Override
    public User createUser(UserDTO userDTO) {
        User user = userDTO.toUser();
        user = userRepository.save(user);
        this.usersRolesRepository.save(new UsersRoles(user, this.roleRepository.getOne(1)));
        return user;
    }

    @Override
    public boolean isAdmin(UserDetails userDetails) {
        if (userDetails != null) {
            User user = this.userRepository.findByLogin(userDetails.getUsername());
            UsersRoles usersRoles = this.usersRolesRepository.getUsersRolesByUser(user);
            if (usersRoles.getRole().getId() == 2) return true;
        }
        return false;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        final Optional<User> user = Optional.ofNullable(userRepository.findByLogin(username));
        final AccountStatusUserDetailsChecker detailsChecker = new AccountStatusUserDetailsChecker();
        user.ifPresent(detailsChecker::check);
        return user.orElseThrow(() -> new UsernameNotFoundException("user not found."));
    }

}