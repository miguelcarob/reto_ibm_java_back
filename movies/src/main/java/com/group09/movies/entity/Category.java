package com.group09.movies.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "category")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_category", nullable = false)
    private Integer id;

    @Column(name = "name_category", length = 400)
    private String nameCategory;

    public String getNameCategory() {
        return nameCategory;
    }

    public void setNameCategory(String nameCategory) {
        this.nameCategory = nameCategory;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    @ManyToMany(mappedBy = "categoriesFilms")
    @JsonIgnore
    private Set<Film> filmsCategory;


    public Set<Film> getFilmsCategory() {
        return filmsCategory;
    }

    public void setFilmsCategory(Set<Film> filmsCategory) {
        this.filmsCategory = filmsCategory;
    }

    public void removeFilm(Film film){
        this.filmsCategory.remove(film);
        film.getCategoriesFilms().remove(this);
    }

    public void removeFilms(){
        for (Film film: filmsCategory){
            removeFilm(film);
        }
    }
}