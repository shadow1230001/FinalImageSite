package com.itransition.lyubin.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;


@Entity
@Table(name = "roles")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Role {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private int id;

    @Column(name = "rolename")
    private String rolename;

}
