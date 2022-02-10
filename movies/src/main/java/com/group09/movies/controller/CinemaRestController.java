package com.group09.movies.controller;

import com.group09.movies.dto.Message;
import com.group09.movies.entity.Cinema;
import com.group09.movies.entity.Subscriber;
import com.group09.movies.service.impl.CinemaService;
import com.group09.movies.service.impl.SubscriberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class CinemaRestController {

    @Autowired
    CinemaService cinemaService;


    @RequestMapping(value = "/cinema/", method = RequestMethod.GET)
    public ResponseEntity<?> findAllCinemas() {
        return new ResponseEntity(cinemaService.getAllCinemas(), HttpStatus.OK);
    }


    @RequestMapping(value = "/cinema/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> getCinema(@PathVariable("id") int id) {

        System.out.println("linea 31");
        return new ResponseEntity(cinemaService.findCinemaById(id), HttpStatus.OK);
        /**
         *
        try{
            System.out.println("linea 33");
            return new ResponseEntity(cinemaService.FindCinemaById(id), HttpStatus.OK);
        }catch (Exception e){
            System.out.println("linea 36");
            return new ResponseEntity(new Message("No se encuentra el Cinema con la información suministrada"), HttpStatus.FORBIDDEN);
        }
         */
    }


    @RequestMapping(value = "/cinema/", method = RequestMethod.PUT)
    public ResponseEntity<?> UpdateCinema(@RequestBody Cinema cinema) {
        Optional<Cinema> cinemaOriginal=cinemaService.findCinemaById(cinema.getId());
        if(cinemaOriginal.isPresent()){
            cinemaOriginal.get().getIdUserCinema().setSurnameUserCinema(cinema.getIdUserCinema().getSurnameUserCinema());
            cinemaOriginal.get().getIdUserCinema().setNameUserCinema(cinema.getIdUserCinema().getNameUserCinema());
            cinemaOriginal.get().setWebCinema(cinema.getWebCinema());
            cinemaOriginal.get().setCityCinema(cinema.getCityCinema());
            cinemaOriginal.get().setAdressCinema(cinema.getAdressCinema());
            return new ResponseEntity(cinemaService.updateCinema(cinemaOriginal.get()), HttpStatus.OK);
        }
        return new ResponseEntity(new Message("No se puede actualizar la información del Cinema"), HttpStatus.FORBIDDEN);
    }


}
