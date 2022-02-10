package com.group09.movies.service.impl;


import com.group09.movies.entity.Subscriber;
import com.group09.movies.entity.UserCinema;
import com.group09.movies.repository.SubscriberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SubscriberService {

    @Autowired
    SubscriberRepository subscriberRepository;

    public Optional<Subscriber> findByidUserCinema(UserCinema id) {
        return subscriberRepository.findByIdUserCinema(id);
    }

    public Subscriber UpdateSubscriber(Subscriber sub){
        return subscriberRepository.save(sub);
    }

    public int getPointsBySuscriber(UserCinema user){
        return subscriberRepository.findByIdUserCinema(user).get().getCurrentPoints();
    }

    public Optional<Subscriber> FindSubscriberById(int id)
    {
        return subscriberRepository.findById(id);
    }
    public List<Subscriber> getAllSubscribers(){
        return  subscriberRepository.findAll();
    }


}
