package com.group09.movies.repository;

import com.group09.movies.entity.AvailableFilm;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AvailableFilmRepository extends JpaRepository<AvailableFilm, Integer> {
}