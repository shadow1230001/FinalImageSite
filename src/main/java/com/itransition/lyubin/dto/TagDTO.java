package com.itransition.lyubin.dto;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.itransition.lyubin.model.Tag;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class TagDTO {
    private Integer idImage;
    private String text;

    public TagDTO(@JsonProperty("idImage") Integer idImage,
                  @JsonProperty("text") String text) {
        this.idImage = idImage;
        this.text = text;
    }

    public Tag toTag() {

        return new Tag(this.text);
    }


}
