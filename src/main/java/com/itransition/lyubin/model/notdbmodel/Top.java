package com.itransition.lyubin.model.notdbmodel;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@NoArgsConstructor
@Getter
@Setter
public class Top {

    private String name;

    private Integer rating;

    private String url;

    public Top(String name, Integer rating, String url) {
        this.name = name;
        this.rating = rating;
        this.url = url;
    }

}
