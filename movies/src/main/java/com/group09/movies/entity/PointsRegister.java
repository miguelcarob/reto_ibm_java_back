package com.group09.movies.entity;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "points_register")
public class PointsRegister {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_points_register", nullable = false)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "id_subscriber")
    private Subscriber idSubscriber;

    @ManyToOne
    @JoinColumn(name = "id_cinema")
    private Cinema idCinema;

    @Column(name = "points_register")
    private Integer pointsRegister;

    @Column(name = "date_register")
    private LocalDate dateRegister;

    @Column(name = "type_points")
    private Integer typePoints;

    public Integer getTypePoints() {
        return typePoints;
    }

    public void setTypePoints(Integer typePoints) {
        this.typePoints = typePoints;
    }

    public LocalDate getDateRegister() {
        return dateRegister;
    }

    public void setDateRegister(LocalDate dateRegister) {
        this.dateRegister = dateRegister;
    }

    public Integer getPointsRegister() {
        return pointsRegister;
    }

    public void setPointsRegister(Integer pointsRegister) {
        this.pointsRegister = pointsRegister;
    }

    public Cinema getIdCinema() {
        return idCinema;
    }

    public void setIdCinema(Cinema idCinema) {
        this.idCinema = idCinema;
    }

    public Subscriber getIdSubscriber() {
        return idSubscriber;
    }

    public void setIdSubscriber(Subscriber idSubscriber) {
        this.idSubscriber = idSubscriber;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}