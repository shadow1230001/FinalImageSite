package com.itransition.lyubin.model.notdbmodel;

import com.itransition.lyubin.model.Role;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class UserInfoForAdmin {

    private Integer id;

    private String name;

    private Integer colLike;

    private Double rating;

    private Role role;

    public UserInfoForAdmin(Integer id, String name, Integer colLike, Double rating, Role role) {
        this.id = id;
        this.name = name;
        this.colLike = colLike;
        this.rating = rating;
        this.role = role;
    }
}
