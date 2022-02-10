package com.group09.movies.controller;

import com.group09.movies.dto.*;
import com.group09.movies.entity.Cinema;
import com.group09.movies.entity.Film;
import com.group09.movies.entity.Subscriber;
import com.group09.movies.entity.UserCinema;
import com.group09.movies.repository.CinemaRepository;
import com.group09.movies.repository.FilmRepository;
import com.group09.movies.repository.SubscriberRepository;
import com.group09.movies.repository.UserCinemaRepository;
import com.group09.movies.service.impl.SubscriberService;
import com.group09.movies.service.impl.UserCinemaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
public class UserRestController {

    @Autowired
    UserCinemaRepository userCinemaRepository;

    @Autowired
    UserCinemaService userCinemaService;
    @Autowired
    SubscriberRepository subscriberRepository;

    @Autowired
    CinemaRepository cinemaRepository;

    @Autowired
    FilmRepository filmRepository;


    @Autowired
    SubscriberService subscriberService;

    public List<UserCinema> getUsers() {
        return null;
    }

    @RequestMapping(value = "/users/", method = RequestMethod.GET)
    public List<Film> getFilms() {
        return filmRepository.findAll();
    }

    @RequestMapping(value = "/users/login2/", method = RequestMethod.POST)
    public String ValidateUser2() {
        System.out.println("hola que tal");
        return "hola";
    }

    @RequestMapping(value = "/users/login/", method = RequestMethod.POST)
    public ResponseEntity<?> ValidateUser(@Valid @RequestBody UserCinemaLoginDto userCinemaLoginDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return new ResponseEntity(new Message("No se puede realizar la petición, Error en los Campos Ingresados"), HttpStatus.BAD_REQUEST);
        }
        Optional<UserCinema> userCinema = userCinemaService.findByUsernameUserCinema(userCinemaLoginDto.getUsernameUserCinema());
        if (userCinema.isPresent())
        {
            if (new BCryptPasswordEncoder().
                    matches(userCinemaLoginDto.getPasswordUserCinema(), userCinema.get().getPasswordUserCinema()))
            {
                UserCinema userCinema1 = userCinema.get();
                UserApp userApp = new UserApp(userCinema1.getUsernameUserCinema(), userCinema1.getNameUserCinema(), userCinema1.getSurnameUserCinema(), userCinema1.getEmailUserCinema());
                if (userCinema.get().getTypeUserCinema() == 1) {
                    // es un usuario tipo administrador
                    UserAdministrator entityUser = new UserAdministrator(userApp);
                    entityUser.setTypeUser(1);
                    return new ResponseEntity(entityUser, HttpStatus.OK);
                } else if (userCinema.get().getTypeUserCinema() == 2) {
                    // es un usuario tipo Suscriptor
                    UserSubscriber entityUser = new UserSubscriber(userApp);
                    int points=subscriberRepository.findByIdUserCinema(userCinema1).get().getCurrentPoints();
                    entityUser.setCurrent_points(points);
                    entityUser.setTypeUser(2);
                    return new ResponseEntity(entityUser, HttpStatus.OK);
                } else {
                    System.out.println("linea 86");
                    // es un usuario tipo Cinema
                    UserCinemaDto entityUser = new UserCinemaDto(userApp);
                    entityUser.setTypeUser(3);
                    Cinema cinema=cinemaRepository.findByIdUserCinema(userCinema1).get();
                    entityUser.setCity_cinema(cinema.getCityCinema());
                    entityUser.setAddress_cinema(cinema.getAdressCinema());
                    entityUser.setWeb_cinema(cinema.getWebCinema());
                    userApp.setTypeUser(3);
                    return new ResponseEntity(entityUser, HttpStatus.OK);
                }
            }
        }
        return new ResponseEntity(new Message("Usuario no encontrado, o credenciales invalidas"), HttpStatus.UNAUTHORIZED);
    }

    @RequestMapping(value = "/users/createSubscriptor/", method = RequestMethod.POST)
    public UserCinema createUserSubscriptor(@Valid @RequestBody UserCinemaLoginDto userCinemaLoginDto, BindingResult bindingResult) {
        return null;
    }



    @RequestMapping(value = "/users/createCinema/", method = RequestMethod.POST)
    public UserCinema CreateUserCinema() {
        return null;
    }


}



