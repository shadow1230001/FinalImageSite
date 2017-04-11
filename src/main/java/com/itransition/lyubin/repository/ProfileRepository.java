package com.itransition.lyubin.repository;

import com.itransition.lyubin.model.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Created by User on 11.04.2017.
 */
public interface ProfileRepository extends JpaRepository<Profile,Integer> {
    @Query(value = "SELECT p FROM  Profile p WHERE p.user.id = ?1")
    Profile findByUserId(Integer id);
}
