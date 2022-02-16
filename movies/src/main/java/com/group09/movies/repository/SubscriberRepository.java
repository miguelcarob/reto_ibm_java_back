package com.group09.movies.repository;

import com.group09.movies.entity.Subscriber;
import com.group09.movies.entity.UserCinema;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface SubscriberRepository extends JpaRepository<Subscriber, Integer> {


    Optional<Subscriber> findByIdUserCinema(UserCinema u);

}