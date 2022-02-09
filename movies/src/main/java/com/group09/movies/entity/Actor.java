package com.group09.movies.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "actor")
public class Actor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_actor", nullable = false)
    private Integer id;

    @Column(name = "name_actor", length = 400)
    private String nameActor;



    public String getNameActor() {
        return nameActor;
    }

    public void setNameActor(String nameActor) {
        this.nameActor = nameActor;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }



    @ManyToMany(mappedBy = "actorsFilms")
    @JsonIgnore
    private Set<Film> filmsActed;

    public Set<Film> getFilmsActed() {
        return filmsActed;
    }

    public void setFilmsActed(Set<Film> filmsActed) {
        this.filmsActed = filmsActed;
    }

    public void removeFilm(Film film){
        this.filmsActed.remove(film);
        film.getActorsFilms().remove(this);
    }

    public void removeFilms(){
        for (Film film: filmsActed){
            removeFilm(film);
        }
    }
}