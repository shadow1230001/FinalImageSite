package com.itransition.lyubin.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "users_profiles")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class UsersProfiles {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user", nullable = false)
    private User user;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "id_profile", nullable = false)
    private Profile profile;

    @Column(name = "rating")
    private Integer rating;

    public UsersProfiles(User user, Profile profile, Integer rating) {
        this.user = user;
        this.profile = profile;
        this.rating = rating;
    }
}