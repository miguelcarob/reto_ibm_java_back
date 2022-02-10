package com.group09.movies.repository;

import com.group09.movies.entity.UserCinema;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserCinemaRepository extends JpaRepository<UserCinema, Integer> {

    Optional<UserCinema> findByUsernameUserCinema (String username);
    boolean existsByUsernameUserCinema (String username);
    boolean existsByEmailUserCinema(String email);

    /**
     *
     * Optional<UserCinema> findByUsernameUserCinema (String username);
     *     boolean existsByUsernameUserCinema (String username);
     *     boolean existsByEmailUserCinema(String email);
     */
}