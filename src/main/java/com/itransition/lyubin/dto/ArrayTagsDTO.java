package com.itransition.lyubin.dto;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class ArrayTagsDTO {
    private List<TagDTO> tags;

    public ArrayTagsDTO(@JsonProperty("tags") List<TagDTO> tags) {
        this.tags = tags;
    }

}
