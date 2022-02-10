package com.group09.movies.repository;

import com.group09.movies.entity.SubscribersFilm;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubscribersFilmRepository extends JpaRepository<SubscribersFilm, Integer> {
}