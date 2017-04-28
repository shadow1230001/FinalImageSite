package com.itransition.lyubin.repository;


import com.itransition.lyubin.model.Profile;
import com.itransition.lyubin.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;

public interface ProfileRepository extends JpaRepository<Profile, Integer> {
    Profile findByUser(User user);

    Profile findByUserId(Integer id);

    Profile findById(Integer id);

    @Query("SELECT p.rating FROM Profile p WHERE p.user.id = :id")
    Integer findRatingByUserId(Integer id);

    @Modifying
    @Transactional
    @Query("update Profile p set p.rating = ?1, p.colLike = ?2 where p.id = ?3")
    int  updateRating(Double rating, Integer colLike, Integer idProfile);
}
