package com.group09.movies.controller;

import com.group09.movies.entity.Director;
import com.group09.movies.repository.DirectorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;



@RestController
public class DirectorRestController {
    @Autowired
    DirectorRepository directorRepository;


    @RequestMapping(value="/director/",method = RequestMethod.GET)
    public List<Director> getDirectors(){
        return directorRepository.findAll();
    }



    @RequestMapping(value="/director/{id}",method = RequestMethod.GET)
    public Director getDirector(@PathVariable("id") int id){
        return directorRepository.findById(id).get();
    }


    @RequestMapping(value="/director/",method = RequestMethod.POST)
    public Director createDirector(@RequestBody Director director){
        return directorRepository.save(director);
    }

    @RequestMapping(value="/director/",method = RequestMethod.PUT)
    public Director UpdateDirector(@RequestBody Director director){
        return directorRepository.save(director);
    }


    @RequestMapping(value="/director/{id}",method = RequestMethod.DELETE)
    public void deleteDirector(@PathVariable("id") int id){
        Optional<Director> director=directorRepository.findById(id);
        if(director.isPresent()){
            director.get().removeFilms();
            directorRepository.deleteById(director.get().getId());
        }
    }
}