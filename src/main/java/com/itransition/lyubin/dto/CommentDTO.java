package com.itransition.lyubin.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.itransition.lyubin.model.Comment;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Created by User on 17.04.2017.
 */
@Getter
@Setter
@NoArgsConstructor
public class CommentDTO {

    private Integer imageId;

    private Integer position;

    private String text;

    public CommentDTO(@JsonProperty("imageId") Integer imageId,
                      @JsonProperty("position") Integer position,
                      @JsonProperty("text") String text){
        this.imageId = imageId;
        this.position = position;
        this.text = text;
    }

    public Comment toCommentWithoutImage(){
        Comment comment = new Comment();
        comment.setPosition(this.position);
        comment.setText(text);
        return comment;
    }
}
