package com.itransition.lyubin.dto;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.itransition.lyubin.model.User;

import java.util.Optional;

public final class UserDTO {

    private final String login;
    private final String password;

    public UserDTO(@JsonProperty("login") String login,
                   @JsonProperty("password") String password) {
        this.login = login;
        this.password = password;
    }


    public Optional<String> getLogin() {
        return Optional.ofNullable(login);
    }

    public Optional<String> getEncodedPassword() {
        //return Optional.ofNullable(password).map(p -> new BCryptPasswordEncoder().encode(p));
        return Optional.ofNullable(password);
    }

    public User toUser() {
        User user = new User();
        user.setLogin(login);
        //user.setPassword(new BCryptPasswordEncoder().encode(password));
        user.setPassword(password);
        return user;
    }

}