package com.group09.movies.entity;

import javax.persistence.*;

@Entity
@Table(name = "offers_subscribers")
public class OffersSubscriber {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_offers_subscribers", nullable = false)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "id_offer")
    private Offer idOffer;

    @ManyToOne
    @JoinColumn(name = "id_subscriber")
    private Subscriber idSubscriber;

    @Column(name = "state_offers_subscribers")
    private Integer stateOffersSubscribers;

    public Integer getStateOffersSubscribers() {
        return stateOffersSubscribers;
    }

    public void setStateOffersSubscribers(Integer stateOffersSubscribers) {
        this.stateOffersSubscribers = stateOffersSubscribers;
    }

    public Subscriber getIdSubscriber() {
        return idSubscriber;
    }

    public void setIdSubscriber(Subscriber idSubscriber) {
        this.idSubscriber = idSubscriber;
    }

    public Offer getIdOffer() {
        return idOffer;
    }

    public void setIdOffer(Offer idOffer) {
        this.idOffer = idOffer;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}