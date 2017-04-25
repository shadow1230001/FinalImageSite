package com.itransition.lyubin.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "images")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Image {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @JsonIgnore
    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
    @JoinColumn(name = "id_profile")
    private Profile profile;

    @Column(name = "position")
    private Integer position;

    @Column(name = "url")
    private String url;

    public Image(Profile profile, Integer position, String url) {
        this.profile = profile;
        this.position = position;
        this.url = url;
    }
}