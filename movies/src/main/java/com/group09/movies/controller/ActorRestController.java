package com.group09.movies.controller;


import com.group09.movies.entity.Actor;
import com.group09.movies.repository.ActorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ActorRestController {

    @Autowired
    ActorRepository repository;


    @RequestMapping(value = "/actor/", method = RequestMethod.GET)
    public List<Actor> getActors() {
        return repository.findAll();
    }


    @RequestMapping(value = "/actor/{id}", method = RequestMethod.GET)
    public Actor getActor(@PathVariable("id") int id) {
        return repository.findById(id).get();
    }


    @RequestMapping(value = "/actor/", method = RequestMethod.POST)
    public Actor createActor(@RequestBody Actor actor) {
        return repository.save(actor);
    }

    @RequestMapping(value = "/actor/", method = RequestMethod.PUT)
    public Actor updateActor(@RequestBody Actor actor) {
        return repository.save(actor);
    }


    @RequestMapping(value = "/actor/{id}", method = RequestMethod.DELETE)
    public void deleteActor(@PathVariable("id") int id) {
        Optional<Actor> actor=repository.findById(id);
        if(actor.isPresent()){
            actor.get().removeFilms();
            repository.deleteById(actor.get().getId());
        }
    }

}
