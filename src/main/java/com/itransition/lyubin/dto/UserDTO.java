package com.itransition.lyubin.dto;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.itransition.lyubin.model.Role;
import com.itransition.lyubin.model.Sex;
import com.itransition.lyubin.model.TypeOfPhotography;
import com.itransition.lyubin.model.User;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Collection;
import java.util.Collections;
import java.util.Optional;


public final class UserDTO {

    private static final String ROLE_USER = "ROLE_USER";

    private final String login;
    private final String password;
    private final String name;
    private final Integer yearOfBirth;
    private final Integer growth;
    private final Integer weight;
    private final Sex sex;
    private final TypeOfPhotography typeOfPhotography;

    public UserDTO(@JsonProperty("login") String login,
                   @JsonProperty("password") String password,
                   @JsonProperty("name") String name,
                   @JsonProperty("yearOfBirth") Integer yearOfBirth,
                   @JsonProperty("growth") Integer growth,
                   @JsonProperty("weight") Integer weight,
                   @JsonProperty("sex") Sex sex,
                   @JsonProperty("typeOfPhotography") TypeOfPhotography typeOfPhotography) {
        this.login = login;
        this.password = password;
        this.name = name;
        this.yearOfBirth = yearOfBirth;
        this.growth = growth;
        this.weight = weight;
        this.sex = sex;
        this.typeOfPhotography = typeOfPhotography;
    }


    public Optional<String> getLogin() {
        return Optional.ofNullable(login);
    }

    public Optional<String> getName() {
        return Optional.ofNullable(name);
    }

    public Optional<Integer> getYearOfBirth() {
        return Optional.ofNullable(yearOfBirth);
    }

    public Optional<Integer> getGrowth() {
        return Optional.ofNullable(growth);
    }

    public Optional<Integer> getWeight() {
        return Optional.ofNullable(weight);
    }

    public Optional<Sex> getSex() {
        return Optional.ofNullable(sex);
    }

    public Optional<TypeOfPhotography> getTypeOfPhotography() {
        return Optional.ofNullable(typeOfPhotography);
    }

    public Optional<String> getEncodedPassword() {
        return Optional.ofNullable(password).map(p -> new BCryptPasswordEncoder().encode(p));
    }

    public User toUser() {
        User user = new User();
        user.setLogin(login);
        user.setRole(new Role());
        user.setGrowth(growth);
        user.setName(name);
        user.setSex(sex);
        user.setTypeOfPhotography(typeOfPhotography);
        user.setWeight(weight);
        user.setYearOfBirth(yearOfBirth);
        user.setPassword(new BCryptPasswordEncoder().encode(password));
        return user;
    }

    public UsernamePasswordAuthenticationToken toAuthenticationToken() {
        return new UsernamePasswordAuthenticationToken(login, password, getAuthorities());
    }

    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singleton(() -> ROLE_USER);
    }

}