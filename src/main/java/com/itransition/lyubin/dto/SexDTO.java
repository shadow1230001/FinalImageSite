package com.itransition.lyubin.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.itransition.lyubin.model.Sex;

import java.util.Optional;


public class SexDTO {
    private final String name;

    public SexDTO(@JsonProperty("name") String name) {
        this.name = name;
    }

    public Optional<String> getName() {
        return Optional.ofNullable(name);
    }

    public Sex toSex() {

        Sex sex = new Sex();

        System.out.print(this.name);
        sex.setName(this.name);
        return sex;
    }

}
