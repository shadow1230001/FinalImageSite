package com.itransition.lyubin.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class AddRatingInfoDTO {
    private Integer rating;
    private Integer profileId;

    public AddRatingInfoDTO(@JsonProperty("rating") Integer rating,
                            @JsonProperty("profileId") Integer profileId){
        this.rating = rating;
        this.profileId = profileId;
    }

}
