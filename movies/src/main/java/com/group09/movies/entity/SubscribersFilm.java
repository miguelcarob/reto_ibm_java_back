package com.group09.movies.entity;

import javax.persistence.*;

@Entity
@Table(name = "subscribers_films")
public class SubscribersFilm {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_subscribers_films", nullable = false)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "id_subscriber")
    private Subscriber idSubscriber;

    @ManyToOne
    @JoinColumn(name = "id_film")
    private Film idFilm;

    @Column(name = "type_film")
    private Integer typeFilm;

    public Integer getTypeFilm() {
        return typeFilm;
    }

    public void setTypeFilm(Integer typeFilm) {
        this.typeFilm = typeFilm;
    }

    public Film getIdFilm() {
        return idFilm;
    }

    public void setIdFilm(Film idFilm) {
        this.idFilm = idFilm;
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