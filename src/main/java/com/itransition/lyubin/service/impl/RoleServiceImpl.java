package com.itransition.lyubin.service.impl;

import com.itransition.lyubin.model.Role;
import com.itransition.lyubin.repository.RoleRepositiry;
import com.itransition.lyubin.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    private RoleRepositiry roleRepositiry;

    @Autowired
    public RoleServiceImpl(RoleRepositiry roleRepositiry) {
        this.roleRepositiry = roleRepositiry;
    }

    @Override
    public List<Role> getAll() {
        return roleRepositiry.findAll();
    }

}
