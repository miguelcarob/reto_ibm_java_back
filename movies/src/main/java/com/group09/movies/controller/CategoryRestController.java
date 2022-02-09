package com.group09.movies.controller;


import com.group09.movies.entity.Category;
import com.group09.movies.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class CategoryRestController {

    @Autowired
    CategoryRepository repository;


    @RequestMapping(value="/category/",method = RequestMethod.GET)
    public List<Category> getCategories(){
        return repository.findAll();
    }



    @RequestMapping(value="/category/{id}",method = RequestMethod.GET)
    public Category getCategory(@PathVariable("id") int id){
        return repository.findById(id).get();
    }


    @RequestMapping(value="/category/",method = RequestMethod.POST)
    public Category createCategory(@RequestBody Category category){
        return repository.save(category);
    }

    @RequestMapping(value="/category/",method = RequestMethod.PUT)
    public Category UpdateCategory(@RequestBody Category category){
        return repository.save(category);
    }


    @RequestMapping(value="/category/{id}",method = RequestMethod.DELETE)
    public void deleteCategory(@PathVariable("id") int id){
        Optional<Category> category=repository.findById(id);
        if(category.isPresent()){
            category.get().removeFilms();
            repository.deleteById(category.get().getId());
        }
    }
}
