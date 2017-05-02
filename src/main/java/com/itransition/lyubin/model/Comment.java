package com.itransition.lyubin.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;


@Entity
@Table(name = "comments")
@Getter
@Setter
@NoArgsConstructor
@ToString

public class Comment {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @JsonIgnore
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "id_image")
    private Image image;

    @Column(name = "title")
    private String title;

    @Column(name = "position")
    private Integer position;

    @Column(name = "text")
    private String text;

}
