package com.itransition.lyubin.model;

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

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user")
    private User user;

    @Column(name = "position")
    private Integer position;

    @Column(name = "url")
    private String url;

    public Image(User user, Integer position, String url) {
        this.user = user;
        this.position = position;
        this.url = url;
    }
}
