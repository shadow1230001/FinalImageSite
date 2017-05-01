package com.itransition.lyubin.service;

import com.itransition.lyubin.model.notdbmodel.UserInfoForAdmin;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;

public interface AdminService {
    List<UserInfoForAdmin> getAdminInfo();

    List<UserInfoForAdmin> getAdminInfoWithCheckAdmin(UserDetails userDetails);
}
