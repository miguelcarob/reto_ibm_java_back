package com.group09.movies.service.impl;

import com.group09.movies.entity.Actor;
import com.group09.movies.repository.ActorRepository;
import com.group09.movies.service.ActorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ActorServiceImpl  implements ActorService {

    @Autowired
    private ActorRepository actorRepository;

    @Override
    public Actor saveActor(Actor actor) {
        return null;
    }
}
