package com.group09.movies.repository;

import com.group09.movies.entity.Offer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OfferRepository extends JpaRepository<Offer, Integer> {


     List<Offer> findByStateOffer(int state);
}