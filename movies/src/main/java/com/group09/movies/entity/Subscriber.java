package com.group09.movies.entity;

import javax.persistence.*;

@Entity
@Table(name = "subscriber")
public class Subscriber {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_subscriber", nullable = false)
    private Integer id;

    @Column(name = "current_points")
    private Integer currentPoints;

    @ManyToOne
    @JoinColumn(name = "id_user_cinema")
    private UserCinema idUserCinema;

    public UserCinema getIdUserCinema() {
        return idUserCinema;
    }

    public void setIdUserCinema(UserCinema idUserCinema) {
        this.idUserCinema = idUserCinema;
    }

    public Integer getCurrentPoints() {
        return currentPoints;
    }

    public void setCurrentPoints(Integer currentPoints) {
        this.currentPoints = currentPoints;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}