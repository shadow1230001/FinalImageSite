package com.itransition.lyubin.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;


@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
@Table(name = "profiles")
public class Profile {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @JsonIgnore
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user", nullable = false)
    private User user;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "id_sex", nullable = false)
    private Sex sex;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "id_types_of_photography", nullable = false)
    private TypeOfPhotography typeOfPhotography;

    @Column(name = "name")
    private String name;

    @Column(name = "yearOfBirth")
    private Integer yearOfBirth;

    @Column(name = "height")
    private Integer height;

    @Column(name = "weight")
    private Integer weight;

    @Column(name = "rating")
    private Double rating;

    @Column(name = "col_like")
    private Integer colLike;
}
