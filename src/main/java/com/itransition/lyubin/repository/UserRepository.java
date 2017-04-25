package com.itransition.lyubin.repository;


import com.itransition.lyubin.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {
    User findByLogin(String login);
}
