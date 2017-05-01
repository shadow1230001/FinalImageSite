package com.itransition.lyubin.dto;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class SexDTO {
    private int id;
    private String name;

    public SexDTO(String name) {

        this.name = name;
    }
}
