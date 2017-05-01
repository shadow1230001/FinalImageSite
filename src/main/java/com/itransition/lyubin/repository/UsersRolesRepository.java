package com.itransition.lyubin.repository;


import com.itransition.lyubin.model.Role;
import com.itransition.lyubin.model.User;
import com.itransition.lyubin.model.UsersRoles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;


public interface UsersRolesRepository extends JpaRepository<UsersRoles, Integer> {
    UsersRoles getUsersRolesByUser(User user);
    @Modifying
    @Transactional
    @Query("update UsersRoles ur set ur.role = ?2 where ur.user = ?1")
    void update(User user, Role role);
}
