package com.group09.movies.controller;


import com.group09.movies.entity.Actor;
import com.group09.movies.entity.Category;
import com.group09.movies.entity.Director;
import com.group09.movies.entity.Film;
import com.group09.movies.repository.ActorRepository;
import com.group09.movies.repository.CategoryRepository;
import com.group09.movies.repository.DirectorRepository;
import com.group09.movies.repository.FilmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class FilmRestController {

    @Autowired
    FilmRepository filmRepository;

    @Autowired
    ActorRepository actorRepository;

    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    DirectorRepository directorRepository;


    @RequestMapping(value = "/film/", method = RequestMethod.GET)
    public List<Film> getFilms() {
        return filmRepository.findAll();
    }


    @RequestMapping(value = "/film/{id}", method = RequestMethod.GET)
    public Film getFilm(@PathVariable("id") int id) {
        return filmRepository.findById(id).get();
    }


    @RequestMapping(value = "/film/", method = RequestMethod.POST)
    public Film createFilm(@RequestBody Film film) {
        return filmRepository.save(film);
    }

    @RequestMapping(value = "/film/", method = RequestMethod.PUT)
    public Film UpdateFilm(@RequestBody Film film) {
        Optional<Film>  filmChange=filmRepository.findById(film.getId());
        if(filmChange.isPresent()){
            filmChange.get().setTitleFilm(film.getTitleFilm());
            filmChange.get().setDescriptionFilm(film.getDescriptionFilm());
            filmChange.get().setReleaseDateFilm(film.getReleaseDateFilm());
        }
        return filmRepository.save(filmChange.get());
    }


    @RequestMapping(value = "/film/{id}", method = RequestMethod.DELETE)
    public void deleteFilm(@PathVariable("id") int id) {
        Optional<Film> film = filmRepository.findById(id);
        if (film.isPresent()) {
            film.get().removeActors();
            film.get().removeCategories();
            film.get().removeDirectors();
            filmRepository.deleteById(film.get().getId());
        } else {
            /**
             * #TODO throw  an exception
             */

        }
    }

    /**
     * Remover un actor de una determinada película.
     * es necesario contar con el id de la pelicula y el id del actor
     * dentro del método de valida si existen o no las entidades relacionadas
     *
     * @param idFilm
     * @param idActor
     * @return pelicula con la información referente a esta.
     */
    @RequestMapping(value = "/film/{idFilm}/actor/{idActor}", method = RequestMethod.DELETE)
    public Film removeActor(@PathVariable("idFilm") int idFilm, @PathVariable("idActor") int idActor) {
        Optional<Film> film = filmRepository.findById(idFilm);
        if (film.isPresent()) {
            Optional<Actor> actor = actorRepository.findById(idActor);
            if (actor.isPresent()) {
                film.get().removeActor(actor.get());
                filmRepository.save(film.get());
            } else {
                /**
                 * #TODO throw  an exception
                 */
            }
        } else {
            /**
             * #TODO throw  an exception
             */
        }
        return film.get();
    }

    @RequestMapping(value = "/film/{idFilm}/actor/{idActor}", method = RequestMethod.POST)
    public Film addActor(@PathVariable("idFilm") int idFilm, @PathVariable("idActor") int idActor) {
        Optional<Film> film = filmRepository.findById(idFilm);
        if (film.isPresent()) {
            Optional<Actor> actor = actorRepository.findById(idActor);
            if (actor.isPresent()) {
                film.get().addActor(actor.get());
                filmRepository.save(film.get());
            } else {
                /**
                 * #TODO throw  an exception
                 */
            }
        } else {
            /**
             * #TODO throw  an exception
             */
        }
        return film.get();
    }

    @RequestMapping(value = "/film/{idFilm}/category/{idCategory}", method = RequestMethod.DELETE)
    public Film removeCategory(@PathVariable("idFilm") int idFilm, @PathVariable("idCategory") int idCategory) {

        Optional<Film> film = filmRepository.findById(idFilm);
        if (film.isPresent()) {
            Optional<Category> category = categoryRepository.findById(idCategory);
            if (category.isPresent()) {
                film.get().removeCategory(category.get());
                filmRepository.save(film.get());
            } else {
                /**
                 * #TODO throw  an exception
                 */
            }
        } else {
            /**
             * #TODO throw  an exception
             */
        }
        return film.get();

    }

    @RequestMapping(value = "/film/{idFilm}/category/{idCategory}", method = RequestMethod.POST)
    public Film addCategory(@PathVariable("idFilm") int idFilm, @PathVariable("idCategory") int idCategory) {

        Optional<Film> film = filmRepository.findById(idFilm);
        if (film.isPresent()) {
            Optional<Category> category = categoryRepository.findById(idCategory);
            if (category.isPresent()) {
                film.get().addCategory(category.get());
                filmRepository.save(film.get());
            } else {
                /**
                 * #TODO throw  an exception
                 */
            }
        } else {
            /**
             * #TODO throw  an exception
             */
        }
        return film.get();
    }

    @RequestMapping(value = "/film/{idFilm}/director/{idDirector}", method = RequestMethod.DELETE)
    public Film removeDirector(@PathVariable("idFilm") int idFilm, @PathVariable("idDirector") int idDirector) {
        Optional<Film> film = filmRepository.findById(idFilm);
        if (film.isPresent()) {
            Optional<Director> director = directorRepository.findById(idDirector);
            if (director.isPresent()) {
                film.get().removeDirector(director.get());
                filmRepository.save(film.get());
            } else {
                /**
                 * #TODO throw  an exception
                 */
            }
        } else {
            /**
             * #TODO throw  an exception
             */
        }
        return film.get();
    }

    @RequestMapping(value = "/film/{idFilm}/director/{idDirector}", method = RequestMethod.POST)
    public Film addDirector(@PathVariable("idFilm") int idFilm, @PathVariable("idDirector") int idDirector) {
        Optional<Film> film = filmRepository.findById(idFilm);
        if (film.isPresent()) {
            Optional<Director> director = directorRepository.findById(idDirector);
            if (director.isPresent()) {
                film.get().addDirector(director.get());
                filmRepository.save(film.get());
            } else {
                /**
                 * #TODO throw  an exception
                 */
            }
        } else {
            /**
             * #TODO throw  an exception
             */
        }
        return film.get();
    }
}



