package com.group09.movies.controller;

import com.group09.movies.dto.*;
import com.group09.movies.entity.Cinema;
import com.group09.movies.entity.Film;
import com.group09.movies.entity.Subscriber;
import com.group09.movies.entity.UserCinema;
import com.group09.movies.service.impl.CinemaService;
import com.group09.movies.service.impl.SubscriberService;
import com.group09.movies.service.impl.UserCinemaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
public class UserRestController {



    @Autowired
    UserCinemaService userCinemaService;

    @Autowired
    CinemaService cinemaService;

      @Autowired
    SubscriberService subscriberService;



    @RequestMapping(value = "/users/login/", method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
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
                if(userCinema1.getStateUserCinema()==0){
                    return new ResponseEntity(new Message("El usuario se ha dado de baja y no puede iniciar sesión"), HttpStatus.FORBIDDEN);

                }
                UserAppDto userApp = new UserAppDto(userCinema1.getUsernameUserCinema(), userCinema1.getNameUserCinema(), userCinema1.getSurnameUserCinema(), userCinema1.getEmailUserCinema());
                if (userCinema.get().getTypeUserCinema() == 1) {
                    // es un usuario tipo administrador
                    UserAdministratorDto entityUser = new UserAdministratorDto(userApp);
                    entityUser.setTypeUser(1);
                    return new ResponseEntity(entityUser, HttpStatus.OK);
                } else if (userCinema.get().getTypeUserCinema() == 2) {
                    // es un usuario tipo Suscriptor
                    UserSubscriberDto entityUser = new UserSubscriberDto(userApp);
                    int points=subscriberService.getPointsBySuscriber(userCinema1);
                    entityUser.setCurrent_points(points);
                    entityUser.setTypeUser(2);
                    return new ResponseEntity(entityUser, HttpStatus.OK);
                } else {
                    System.out.println("linea 86");
                    // es un usuario tipo Cinema
                    UserCinemaDto entityUser = new UserCinemaDto(userApp);
                    entityUser.setTypeUser(3);
                    Cinema cinema=cinemaService.findByIdUserCinema(userCinema1);
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

    @CrossOrigin
    @RequestMapping(value = "/users/createSubscriber/", method = RequestMethod.POST)
    public ResponseEntity<?> createUserSubscriber(@Valid @RequestBody NewUserSubscriberDto newUserSubscriberDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            StringBuilder errors=new StringBuilder();
            for (ObjectError error : bindingResult.getAllErrors()) {
                errors.append(error.getDefaultMessage());
                errors.append(",");
        }
            errors.deleteCharAt(errors.lastIndexOf(","));
            return new ResponseEntity(new Message(errors.toString()), HttpStatus.BAD_REQUEST);
        }
        String responseValidate=validateUserFields(newUserSubscriberDto.getUsernameUserCinema(),newUserSubscriberDto.getEmailUserCinema());
        if(!responseValidate.equals("1")){
            return new ResponseEntity(new Message(responseValidate), HttpStatus.CONFLICT);
        }
        UserCinema userCinema=new UserCinema();
        userCinema.setUsernameUserCinema(newUserSubscriberDto.getUsernameUserCinema());
        userCinema.setPasswordUserCinema(new BCryptPasswordEncoder().encode(newUserSubscriberDto.getPasswordUserCinema()));
        userCinema.setNameUserCinema(newUserSubscriberDto.getNameUserCinema());
        userCinema.setSurnameUserCinema(newUserSubscriberDto.getSurnameUserCinema());
        userCinema.setEmailUserCinema(newUserSubscriberDto.getEmailUserCinema());
        userCinema.setTypeUserCinema(2);
        userCinema.setStateUserCinema(1);
        Subscriber sub=new Subscriber();
        sub.setCurrentPoints(0);
        userCinemaService.createSubscriber(userCinema,sub);
        return new ResponseEntity(new Message("Se ha creado con exito el usuario"), HttpStatus.OK);

    }



    @RequestMapping(value = "/users/createCinema/", method = RequestMethod.POST)
    public ResponseEntity<?> CreateUserCinema(@Valid @RequestBody NewUserCinemaDto newUserCinemaDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            StringBuilder errors=new StringBuilder();
            for (ObjectError error : bindingResult.getAllErrors()) {
                errors.append(error.getDefaultMessage());
                errors.append(",");
            }
            errors.deleteCharAt(errors.lastIndexOf(","));
            return new ResponseEntity(new Message(errors.toString()), HttpStatus.BAD_REQUEST);
        }
        String responseValidate=validateUserFields(newUserCinemaDto.getUsernameUserCinema(),newUserCinemaDto.getEmailUserCinema());
        if(!responseValidate.equals("1")){
            return new ResponseEntity(new Message(responseValidate), HttpStatus.CONFLICT);
        }
        UserCinema userCinema=new UserCinema();
        userCinema.setUsernameUserCinema(newUserCinemaDto.getUsernameUserCinema());
        userCinema.setPasswordUserCinema(new BCryptPasswordEncoder().encode(newUserCinemaDto.getPasswordUserCinema()));
        userCinema.setNameUserCinema(newUserCinemaDto.getNameUserCinema());
        userCinema.setSurnameUserCinema(newUserCinemaDto.getSurnameUserCinema());
        userCinema.setEmailUserCinema(newUserCinemaDto.getEmailUserCinema());
        userCinema.setTypeUserCinema(3);
        userCinema.setStateUserCinema(1);
        Cinema cinema=new Cinema();
        cinema.setCityCinema(newUserCinemaDto.getCity_cinema());
        cinema.setAdressCinema(newUserCinemaDto.getAddress_cinema());
        cinema.setWebCinema(newUserCinemaDto.getWeb_cinema());
        userCinemaService.createCinema(userCinema,cinema);
        return new ResponseEntity(new Message("Se ha creado con exito el usuario"), HttpStatus.OK);

    }




    @RequestMapping(value="/users/unsubscribe/{id}",method = RequestMethod.DELETE)
    public ResponseEntity<?> unsubscribeUser(@PathVariable("id") int id){
        if(userCinemaService.unsubscribeUser(id).getStateUserCinema()==0){
            return new ResponseEntity(new Message("Se ha dado de baja al usuario"), HttpStatus.ACCEPTED);
        }
        return new ResponseEntity(new Message("No se ha podido dar de baja al usuario"), HttpStatus.FORBIDDEN);
    }




    public String validateUserFields(String username,String email){
        boolean userCinemaUsername = userCinemaService.existsByUsernameUserCinema(username);
        if (userCinemaUsername){
            return "El usuario ya se encuentra en el sistema";
        }
        boolean userCinemaEmail = userCinemaService.existsByEmailUserCinema(email);
        if (userCinemaEmail){
            return "El correo ya se encuentra en el sistema";
        }
        return "1";
    }





}



