package com.group09.movies.service.impl;


import com.group09.movies.entity.Cinema;
import com.group09.movies.entity.Subscriber;
import com.group09.movies.entity.UserCinema;
import com.group09.movies.repository.CinemaRepository;
import com.group09.movies.repository.SubscriberRepository;
import com.group09.movies.repository.UserCinemaRepository;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@Transactional
public class UserCinemaService {


    @Autowired
    UserCinemaRepository userCinemaRepository;

    @Autowired
    CinemaRepository cinemaRepository;

    @Autowired
    SubscriberRepository subscriberRepository;


    public Optional<UserCinema> findByUsernameUserCinema(String username) {
        return userCinemaRepository.findByUsernameUserCinema(username);
    }

    public boolean existsByUsernameUserCinema(String username) {
        return userCinemaRepository.existsByUsernameUserCinema(username);
    }

    public boolean existsByEmailUserCinema(String email) {
        return userCinemaRepository.existsByEmailUserCinema(email);
    }

    public UserCinema saveUserCinema(UserCinema userCinema) {
        return userCinemaRepository.save(userCinema);
    }

    public UserCinema unsubscribeUser(int id) {
        Optional<UserCinema> userCinema = userCinemaRepository.findById(id);
        userCinema.get().setStateUserCinema(0);
        return userCinemaRepository.save(userCinema.get());

    }

    public UserCinema editInformationRegular(UserCinema userCinema) {
        return userCinemaRepository.save(userCinema);
    }

    public UserCinema editInformationCinema(UserCinema userCinema, Cinema cinema) {
        cinemaRepository.save(cinema);
        return userCinemaRepository.save(userCinema);
    }

    public void createSubscriber(UserCinema user, Subscriber sub) {
        UserCinema newUser = userCinemaRepository.save(user);
        sub.setIdUserCinema(newUser);
        subscriberRepository.save(sub);
    }


    public void createCinema(UserCinema user, Cinema cinema) {
        UserCinema newUser = userCinemaRepository.save(user);
        cinema.setIdUserCinema(newUser);
        cinemaRepository.save(cinema);
    }


}
