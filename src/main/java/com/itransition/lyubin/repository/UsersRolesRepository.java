package com.itransition.lyubin.repository;


import com.itransition.lyubin.model.User;
import com.itransition.lyubin.model.UsersRoles;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRolesRepository extends JpaRepository<UsersRoles, Integer> {
    UsersRoles getUsersRolesByUser(User user);
}
