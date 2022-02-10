package com.group09.movies.service.impl;


import com.group09.movies.entity.Cinema;
import com.group09.movies.entity.UserCinema;
import com.group09.movies.repository.CinemaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.module.FindException;
import java.util.List;
import java.util.Optional;

@Service
public class CinemaService {


    @Autowired
    CinemaRepository cinemaRepository;



    public Cinema  findByIdUserCinema(UserCinema user){
        return cinemaRepository.findByIdUserCinema(user).get();
    }


    public Optional<Cinema> findCinemaById(int id){
        return cinemaRepository.findById(id);

    }

    public Cinema updateCinema(Cinema cinema){
        return cinemaRepository.save(cinema);
    }

    public List<Cinema> getAllCinemas() {
    return cinemaRepository.findAll();
    }
}
