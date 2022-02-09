package com.group09.movies.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "director")
public class Director {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_director", nullable = false)
    private Integer id;

    @Column(name = "name_director", length = 400)
    private String nameDirector;

    public String getNameDirector() {
        return nameDirector;
    }

    public void setNameDirector(String nameDirector) {
        this.nameDirector = nameDirector;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }



    @ManyToMany(mappedBy = "directorsFilms")
    @JsonIgnore
    private Set<Film> filmsDirector;

    public Set<Film> getFilmsDirector() {
        return filmsDirector;
    }

    public void setFilmsDirector(Set<Film> filmsDirector) {
        this.filmsDirector = filmsDirector;
    }

    public void removeFilm(Film film){
        this.filmsDirector.remove(film);
        film.getDirectorsFilms().remove(this);
    }

    public void removeFilms(){
        for (Film film: filmsDirector){
            removeFilm(film);
        }
    }

}