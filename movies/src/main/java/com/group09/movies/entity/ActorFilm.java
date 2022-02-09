package com.group09.movies.entity;

import javax.persistence.*;

@Entity
@Table(name = "actor_films")
public class ActorFilm {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_actor_films", nullable = false)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "id_actor")
    private Actor idActor;

    @ManyToOne
    @JoinColumn(name = "id_film")
    private Film idFilm;

    public Film getIdFilm() {
        return idFilm;
    }

    public void setIdFilm(Film idFilm) {
        this.idFilm = idFilm;
    }

    public Actor getIdActor() {
        return idActor;
    }

    public void setIdActor(Actor idActor) {
        this.idActor = idActor;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}