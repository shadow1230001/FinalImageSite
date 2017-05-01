package com.itransition.lyubin.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.itransition.lyubin.model.Image;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class ArrayImagesDTO {

    private List<Image> images;

    public ArrayImagesDTO(@JsonProperty("images") List<Image> images){
        this.images = images;
    }

}