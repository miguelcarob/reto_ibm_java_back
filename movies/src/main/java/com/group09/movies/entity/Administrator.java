package com.group09.movies.entity;

import javax.persistence.*;

@Entity
@Table(name = "administrator")
public class Administrator {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_administrator", nullable = false)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "id_user_cinema")
    private UserCinema idUserCinema;

    public UserCinema getIdUserCinema() {
        return idUserCinema;
    }

    public void setIdUserCinema(UserCinema idUserCinema) {
        this.idUserCinema = idUserCinema;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}