package com.itransition.lyubin.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;


@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class User {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "login", nullable = false)
    private String login;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "role", nullable = false)
    private String role;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "yearOfBirth", nullable = false)
    private Integer yearOfBirth;

    @Column(name = "growth", nullable = false)
    private Integer growth;

    @Column(name = "weight", nullable = false)
    private Integer weight;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "id_sex", nullable = false)
    private Sex sex;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "id_types_of_photography", nullable = false)
    private TypeOfPhotography typeOfPhotography;

    public User(String login, String password, String role, String name,
                Integer yearOfBirth, Integer growth, Integer weight,
                Sex sex, TypeOfPhotography typeOfPhotography) {
        this.login = login;
        this.password = password;
        this.role = role;
        this.name = name;
        this.yearOfBirth = yearOfBirth;
        this.growth = growth;
        this.weight = weight;
        this.sex = sex;
        this.typeOfPhotography = typeOfPhotography;
    }
}
