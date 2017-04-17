package com.itransition.lyubin.repository;

import com.itransition.lyubin.model.Profile;
import com.itransition.lyubin.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * Created by User on 11.04.2017.
 */
public interface ProfileRepository extends JpaRepository<Profile, Integer> {
    Profile findByUser(User user);

    Profile findByUserId(Integer id);

    Profile findById(Integer id);

    @Query("SELECT p.rating FROM Profile p WHERE p.user.id = :id")
    Integer findRatingByUserId(Integer id);
}
