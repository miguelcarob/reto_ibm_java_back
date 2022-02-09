package com.group09.movies.entity;

import javax.persistence.*;

@Entity
@Table(name = "available_films")
public class AvailableFilm {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_available_films", nullable = false)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "id_film")
    private Film idFilm;

    @ManyToOne
    @JoinColumn(name = "id_cinema")
    private Cinema idCinema;

    @Column(name = "state_available_films")
    private Integer stateAvailableFilms;

    @Column(name = "description_available_films")
    private Integer descriptionAvailableFilms;

    public Integer getDescriptionAvailableFilms() {
        return descriptionAvailableFilms;
    }

    public void setDescriptionAvailableFilms(Integer descriptionAvailableFilms) {
        this.descriptionAvailableFilms = descriptionAvailableFilms;
    }

    public Integer getStateAvailableFilms() {
        return stateAvailableFilms;
    }

    public void setStateAvailableFilms(Integer stateAvailableFilms) {
        this.stateAvailableFilms = stateAvailableFilms;
    }

    public Cinema getIdCinema() {
        return idCinema;
    }

    public void setIdCinema(Cinema idCinema) {
        this.idCinema = idCinema;
    }

    public Film getIdFilm() {
        return idFilm;
    }

    public void setIdFilm(Film idFilm) {
        this.idFilm = idFilm;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}