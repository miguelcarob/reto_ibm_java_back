package com.group09.movies.controller;

import com.group09.movies.dto.Message;
import com.group09.movies.dto.NewOfferDTO;
import com.group09.movies.dto.UpdateOfferDTO;
import com.group09.movies.entity.Category;
import com.group09.movies.entity.Offer;
import com.group09.movies.repository.CategoryRepository;
import com.group09.movies.service.impl.OfferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;


@RestController
public class OffersRestController {


    @Autowired
    OfferService offerService;

    /**
     * return new ResponseEntity(new Message("No se puede actualizar la información del Cinema"), HttpStatus.FORBIDDEN);
     */


    @RequestMapping(value = "/offer/", method = RequestMethod.GET)
    public ResponseEntity<?> getOffers() {
        return new ResponseEntity(offerService.getAllOffers(), HttpStatus.OK);

    }

    @RequestMapping(value = "/offer/state/{state}", method = RequestMethod.GET)
    public ResponseEntity<?> getOffersActive(@PathVariable("state") int state) {
        return new ResponseEntity(offerService.getAllOffersByState(state), HttpStatus.OK);

    }


    @RequestMapping(value = "/offer/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> getOffer(@PathVariable("id") int id) {
        Optional<Offer> offer = offerService.findOfferById(id);
        if (offer.isPresent()) {
            return new ResponseEntity(offerService.findOfferById(id), HttpStatus.OK);
        } else {
            return new ResponseEntity(new Message("Error al momento de buscar la oferta"), HttpStatus.BAD_REQUEST);
        }

    }


    @RequestMapping(value = "/offer/", method = RequestMethod.POST)
    public ResponseEntity<?> createOffer(@Valid  @RequestBody NewOfferDTO newOfferDTO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            StringBuilder errors=new StringBuilder();
            for (ObjectError error : bindingResult.getAllErrors()) {
                errors.append(error.getDefaultMessage());
                errors.append(",");
            }
            errors.deleteCharAt(errors.lastIndexOf(","));
            return new ResponseEntity(new Message(errors.toString()), HttpStatus.BAD_REQUEST);
        }
        Offer offer = offerService.createOffer(newOfferDTO);
        if(offer!=null){
            return new ResponseEntity(offer, HttpStatus.OK);
        }else{
            return new ResponseEntity(new Message("Error al momento de crear la oferta"), HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(value = "/offer/", method = RequestMethod.PUT)
    public ResponseEntity<?> UpdateOffer(@Valid @RequestBody UpdateOfferDTO offerDTO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            StringBuilder errors=new StringBuilder();
            for (ObjectError error : bindingResult.getAllErrors()) {
                errors.append(error.getDefaultMessage());
                errors.append(",");
            }
            errors.deleteCharAt(errors.lastIndexOf(","));
            return new ResponseEntity(new Message(errors.toString()), HttpStatus.BAD_REQUEST);
        }
       Offer offer=offerService.updateOffer(offerDTO);
        if(offer!=null){
            return new ResponseEntity(offer, HttpStatus.OK);
        }else{
            return new ResponseEntity(new Message("No se puede actualizar la oferta"), HttpStatus.BAD_REQUEST);
        }
    }


    @RequestMapping(value = "/offer/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteOffer(@PathVariable("id") int id) {
        if(offerService.deleteOffer(id)){
            return new ResponseEntity(new Message("Se ha dado de baja a la oferta"), HttpStatus.OK);
        }
        return new ResponseEntity(new Message("No se pudo dar de baja a la oferta"), HttpStatus.BAD_REQUEST);
    }

    @RequestMapping(value = "/offer/subscriber/{idSubscriber}/offer/{idOffer}", method = RequestMethod.GET)
    public ResponseEntity<?> applyOffer(@PathVariable("idSubscriber") int idSubscriber,@PathVariable("idOffer") int idOffer){
        if(offerService.applyOfferToSubscriber(idOffer,idSubscriber)){

        return new ResponseEntity(new Message("Se ha aplicado la oferta al usuario"), HttpStatus.OK);
        }
        return new ResponseEntity(new Message("No se pudo aplicar la oferta al usuario"), HttpStatus.BAD_REQUEST);
    }

}
