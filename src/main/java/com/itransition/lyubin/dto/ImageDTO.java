package com.itransition.lyubin.dto;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.itransition.lyubin.model.Image;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ImageDTO {

    private Integer idProfile;

    private Integer position;

    private String url;

    public ImageDTO(@JsonProperty("idProfile") Integer idUser,
                    @JsonProperty("position") Integer position,
                    @JsonProperty("url") String url) {
        this.idProfile = idProfile;
        this.position = position;
        this.url = url;
    }

    public Image toImageWithoutUser(){
        Image image = new Image();
        image.setPosition(this.position);
        image.setUrl(this.url);
        return image;
    }
}
