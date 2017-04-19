package com.itransition.lyubin.dto;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.itransition.lyubin.model.Profile;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ProfileDTO {

    private Integer idUser;

    private Integer idSex;

    private Integer idTypeOfPhotography;

    private String name;

    private Integer yearOfBirth;

    private Integer height;

    private Integer weight;

    private Double rating;

    private Integer colLike;

    public ProfileDTO(@JsonProperty("idUser") Integer idUser,
                      @JsonProperty("idSex") Integer idSex,
                      @JsonProperty("idTypeOfPhotography") Integer idTypeOfPhotography,
                      @JsonProperty("name") String name,
                      @JsonProperty("yearOfBirth") Integer yearOfBirth,
                      @JsonProperty("height") Integer height,
                      @JsonProperty("weight") Integer weight,
                      @JsonProperty("rating") Double rating,
                      @JsonProperty("colLike") Integer colLike) {
        this.idUser = idUser;
        this.idSex = idSex;
        this.idTypeOfPhotography = idTypeOfPhotography;
        this.name = name;
        this.yearOfBirth = yearOfBirth;
        this.height = height;
        this.weight = weight;
        this.rating = rating;
        this.colLike = colLike;
    }

    public Profile toProfileWithoutUserSexTypeOfPhotography(){
        Profile profile = new Profile();
        profile.setName(this.name);
        profile.setYearOfBirth(this.yearOfBirth);
        profile.setHeight(this.height);
        profile.setWeight(this.weight);
        profile.setRating(this.rating);
        profile.setColLike(this.colLike);
        return profile;
    }
}
