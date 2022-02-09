package com.group09.movies.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "film")
public class Film {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_film", nullable = false)
    private Integer id;

    @Column(name = "title_film", length = 300)
    private String titleFilm;

    @Column(name = "description_film", length = 500)
    private String descriptionFilm;

    @Column(name = "release_date_film")
    private LocalDate releaseDateFilm;


    public LocalDate getReleaseDateFilm() {
        return releaseDateFilm;
    }

    public void setReleaseDateFilm(LocalDate releaseDateFilm) {
        this.releaseDateFilm = releaseDateFilm;
    }

    public String getDescriptionFilm() {
        return descriptionFilm;
    }

    public void setDescriptionFilm(String descriptionFilm) {
        this.descriptionFilm = descriptionFilm;
    }

    public String getTitleFilm() {
        return titleFilm;
    }

    public void setTitleFilm(String titleFilm) {
        this.titleFilm = titleFilm;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    /**
     * Relation with Actor
     *
     */

    @JoinTable(
            name = "actor_films",
            joinColumns = @JoinColumn(name = "id_film", nullable = false),
            inverseJoinColumns = @JoinColumn(name="id_actor", nullable = false)
    )
    @ManyToMany(cascade = CascadeType.ALL)
    private Set<Actor> actorsFilms;


    public void removeActor(Actor actor){
        this.getActorsFilms().remove(actor);
        actor.getFilmsActed().remove(this);
    }

    public void addActor(Actor actor){
        actorsFilms.add(actor);
        actor.getFilmsActed().add(this);
    }

    public void removeActors(){
        for (Actor actor: new HashSet<>(actorsFilms)){
            removeActor(actor);
        }
    }


    public Set<Actor> getActorsFilms() {
        return actorsFilms;
    }

    public void setActorsFilms(Set<Actor> actors) {
        this.actorsFilms = actors;
    }

    /**
     * Relation with Category
     *
     */
    @JoinTable(
            name = "category_films",
            joinColumns = @JoinColumn(name = "id_film", nullable = false),
            inverseJoinColumns = @JoinColumn(name="id_category", nullable = false)
    )
    @ManyToMany(cascade = CascadeType.ALL)
    private Set<Category> categoriesFilms;


    public void removeCategory(Category category){
        this.getCategoriesFilms().remove(category);
        category.getFilmsCategory().remove(this);
    }

    public void addCategory(Category category){
        categoriesFilms.add(category);
        category.getFilmsCategory().add(this);
    }

    /**
     * #TODO  Falta agregar el actor
     */

    public void removeCategories(){
        for (Category category: new HashSet<>(categoriesFilms)){
            removeCategory(category);
        }
    }
    public Set<Category> getCategoriesFilms() {
        return categoriesFilms;
    }

    public void setCategoriesFilms(Set<Category> categories) {
        this.categoriesFilms = categories;
    }


    /**
     * Relation with Director
     *
     */
    @JoinTable(
            name = "director_films",
            joinColumns = @JoinColumn(name = "id_film", nullable = false),
            inverseJoinColumns = @JoinColumn(name="id_director", nullable = false)
    )
    @ManyToMany(cascade = CascadeType.ALL)
    private Set<Director> directorsFilms;

    public Set<Director> getDirectorsFilms() {
        return directorsFilms;
    }

    public void setDirectorsFilms(Set<Director> directorsFilms) {
        this.directorsFilms = directorsFilms;
    }

    public void removeDirector(Director director){
        this.getDirectorsFilms().remove(director);
        director.getFilmsDirector().remove(this);
    }

    public void addDirector(Director director){
        directorsFilms.add(director);
        director.getFilmsDirector().add(this);
    }



    public void removeDirectors(){
        for (Director director: new HashSet<>(directorsFilms)){
            removeDirector(director);
        }
    }


}