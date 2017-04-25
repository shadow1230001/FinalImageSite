package com.itransition.lyubin.dto;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PersonContext{
    private UserDTO userDTO;
    private ProfileDTO profileDTO;
    private ImageDTO imageDTO;
    public PersonContext(@JsonProperty("user") UserDTO userDTO,
                         @JsonProperty("profile") ProfileDTO profileDTO,
                         @JsonProperty("image") ImageDTO imageDTO){
        this.userDTO = userDTO;
        this.profileDTO = profileDTO;
        this.imageDTO = imageDTO;
    }
}
