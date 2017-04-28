package com.itransition.lyubin.model.notdbmodel;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class Top {

    private Integer id;

    private String name;

    private Double rating;

    private String url;

    public Top(Integer id, String name, Double rating, String url){
        this.id = id;
        this.name = name;
        this.rating = rating;
        this.url = url;
    }
}