package com.group09.movies.service.impl;


import com.group09.movies.dto.NewOfferDto;
import com.group09.movies.dto.UpdateOfferDto;
import com.group09.movies.entity.Cinema;
import com.group09.movies.entity.Offer;
import com.group09.movies.entity.OffersSubscriber;
import com.group09.movies.entity.Subscriber;
import com.group09.movies.repository.OfferRepository;
import com.group09.movies.repository.OffersSubscriberRepository;
import com.group09.movies.repository.SubscriberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class OfferService {

    @Autowired
    OfferRepository offerRepository;

    @Autowired
    SubscriberRepository subscriberRepository;


    @Autowired
    OffersSubscriberRepository offersSubscriberRepository;

    @Autowired
    CinemaService cinemaService;




    public Optional<Offer> findOfferById(int id) {
        return offerRepository.findById(id);
    }

    public List<Offer> getAllOffers() {
        return offerRepository.findAll();
    }

    public List<Offer> getAllOffersByState(int state) {
        return offerRepository.findByStateOffer(state);
    }


    public List<Offer> getAllByCinema(int idCinema){
        Cinema c= cinemaService.findCinemaById(idCinema).get();
        return offerRepository.findByIdCinema(c);
    }



    public Offer updateOffer(UpdateOfferDto offer) {
        // #TODO realizar el método
        Optional<Offer> offerUpdate = offerRepository.findById(offer.getId());
        if (offerUpdate.isPresent()) {
            offerUpdate.get().setDeadlineOffer(offer.getDeadlineOffer());
            offerUpdate.get().setDescriptionOffer(offer.getDescriptionOffer());
            int addPoints = offer.getAddPoints();
            int subPoints = offer.getSubPoints();
            offerUpdate.get().setAddPoints(addPoints);
            offerUpdate.get().setSubPoints(subPoints);
            offerUpdate.get().setPoints(addPoints - subPoints);
            offerUpdate.get().setTotalOffers(offer.getTotalOffers());
        }
        return offerRepository.save(offerUpdate.get());
    }

    public Offer createOffer(NewOfferDto newOfferDTO) {
        Optional<Cinema> cinema = cinemaService.findCinemaById(newOfferDTO.getIdCinema());
        if (cinema.isPresent()) {
            Offer offer = new Offer();
            offer.setStateOffer(1);
            offer.setTotalOffers(newOfferDTO.getTotalOffers());
            offer.setCurrentOffers(0);
            offer.setDeadlineOffer(newOfferDTO.getDeadlineOffer());
            offer.setDescriptionOffer(newOfferDTO.getDescriptionOffer());
            int addPoints = newOfferDTO.getAddPoints();
            int subPoints = newOfferDTO.getSubPoints();
            offer.setAddPoints(addPoints);
            offer.setSubPoints(subPoints);
            offer.setPoints(addPoints - subPoints);
            offer.setIdCinema(cinema.get());
            return offerRepository.save(offer);
        }
        return null;
    }


    public boolean deleteOffer(int id) {
        Optional<Offer> offerUpdate = offerRepository.findById(id);
        if (offerUpdate.isPresent()) {
            offerUpdate.get().setStateOffer(0);
            offerRepository.save(offerUpdate.get());
            return true;
        }
        return false;


    }

    public boolean  applyOfferToSubscriber(int idOffer, int idSub) {

        Optional<Subscriber> sub= subscriberRepository.findById(idSub);
        Optional<Offer> offer=offerRepository.findById(idOffer);
        if(!sub.isPresent()){
            return false;
        }
        if(!offer.isPresent()){
            return false;
        }
        OffersSubscriber offersSubscriber=new OffersSubscriber();
        offersSubscriber.setIdSubscriber(sub.get());
        offersSubscriber.setIdOffer(offer.get());
        offersSubscriber.setStateOffersSubscribers(1);
        offersSubscriberRepository.save(offersSubscriber);
        return true;
    }

    public void requestOfferSubscriber(Offer offer, Subscriber sub) {

    }


}
