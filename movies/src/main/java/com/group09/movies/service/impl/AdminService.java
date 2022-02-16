package com.group09.movies.service.impl;


import com.group09.movies.entity.Administrator;
import com.group09.movies.entity.Cinema;
import com.group09.movies.entity.UserCinema;
import com.group09.movies.repository.AdministratorRepository;
import com.group09.movies.repository.CinemaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AdminService {


    @Autowired
    AdministratorRepository administratorRepository;



    public Administrator findByIdUserCinema(UserCinema user){
        System.out.println((user));
        return administratorRepository.findByIdUserCinema(user).get();
    }


    public Optional<Administrator> findAdminById(int id){

        return  administratorRepository.findById(id);

    }

    public List<Administrator> getAllAdministrators(){
        return administratorRepository.findAll();
    }

    public Administrator updateCinema(Administrator administrator){
        return administratorRepository.save(administrator);
    }

}
