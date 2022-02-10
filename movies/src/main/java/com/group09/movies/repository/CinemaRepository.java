package com.group09.movies.repository;

import com.group09.movies.entity.Cinema;
import com.group09.movies.entity.Subscriber;
import com.group09.movies.entity.UserCinema;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CinemaRepository extends JpaRepository<Cinema, Integer> {


    Optional<Cinema> findByIdUserCinema(UserCinema userCinema);
}