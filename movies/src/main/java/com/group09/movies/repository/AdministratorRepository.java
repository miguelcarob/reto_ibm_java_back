package com.group09.movies.repository;

import com.group09.movies.entity.Administrator;
import com.group09.movies.entity.Subscriber;
import com.group09.movies.entity.UserCinema;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AdministratorRepository extends JpaRepository<Administrator, Integer> {



    Optional<Administrator> findByIdUserCinema(UserCinema u);
}