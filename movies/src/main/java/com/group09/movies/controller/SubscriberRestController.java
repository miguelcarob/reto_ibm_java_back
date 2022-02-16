package com.group09.movies.controller;


import com.group09.movies.dto.Message;
import com.group09.movies.entity.Subscriber;
import com.group09.movies.service.impl.SubscriberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class SubscriberRestController {


    @Autowired
    SubscriberService subscriberService;


    @RequestMapping(value = "/subscribers/", method = RequestMethod.GET)
    public ResponseEntity<?> findAllsubscribers() {
        Message m= new Message(subscriberService.getAllSubscribers(),"200");
        return new ResponseEntity(m, HttpStatus.OK);
    }


    @RequestMapping(value = "/subscribers/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> getsubscriber(@PathVariable("id") int id) {

        try{
            Message m = new Message(subscriberService.getAllSubscribers(),"200");
            return new ResponseEntity(m, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity(new Message("No se encuentra el subscriptor con la información suministrada","403"), HttpStatus.FORBIDDEN);
        }
    }


    @RequestMapping(value = "/subscribers/", method = RequestMethod.PUT)
    public ResponseEntity<?> UpdateInformationSubscriber(@RequestBody Subscriber subscriber) {
        Optional<Subscriber> subscriberOriginal=subscriberService.FindSubscriberById(subscriber.getId());
        if(subscriberOriginal.isPresent()){
            subscriberOriginal.get().getIdUserCinema().setSurnameUserCinema(subscriber.getIdUserCinema().getSurnameUserCinema());
            subscriberOriginal.get().getIdUserCinema().setNameUserCinema(subscriber.getIdUserCinema().getNameUserCinema());


            Message m= new Message(subscriberService.UpdateSubscriber(subscriberOriginal.get()), "200");
            return new ResponseEntity(m,HttpStatus.OK);
        }
        return new ResponseEntity(new Message("No se puede actualizar la información del subscriptor","403"), HttpStatus.FORBIDDEN);
    }






}
