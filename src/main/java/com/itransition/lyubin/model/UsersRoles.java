package com.itransition.lyubin.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

/**
 * Created by User on 17.04.2017.
 */
@Entity
@Table(name = "users_roles")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class UsersRoles {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private Integer id;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user")
    private User user;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "id_role")
    private Role role;

    public UsersRoles(User user, Role role){
        this.user = user;
        this.role = role;
    }
}
