package com.group09.movies.entity;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "offer")
public class Offer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_offer", nullable = false)
    private Integer id;

    @Column(name = "description_offer", length = 200)
    private String descriptionOffer;

    @Column(name = "deadline_offer")
    private LocalDate deadlineOffer;

    @Column(name = "points")
    private Integer points;

    @Column(name = "add_points")
    private Integer addPoints;

    @Column(name = "sub_points")
    private Integer subPoints;

    @ManyToOne
    @JoinColumn(name = "id_cinema")
    private Cinema idCinema;

    @Column(name = "total_offers")
    private Integer totalOffers;

    @Column(name = "current_offers")
    private Integer currentOffers;

    @Column(name = "state_offer")
    private Integer stateOffer;

    public Integer getStateOffer() {
        return stateOffer;
    }

    public void setStateOffer(Integer stateOffer) {
        this.stateOffer = stateOffer;
    }

    public Integer getCurrentOffers() {
        return currentOffers;
    }

    public void setCurrentOffers(Integer currentOffers) {
        this.currentOffers = currentOffers;
    }

    public Integer getTotalOffers() {
        return totalOffers;
    }

    public void setTotalOffers(Integer totalOffers) {
        this.totalOffers = totalOffers;
    }

    public Cinema getIdCinema() {
        return idCinema;
    }

    public void setIdCinema(Cinema idCinema) {
        this.idCinema = idCinema;
    }

    public Integer getSubPoints() {
        return subPoints;
    }

    public void setSubPoints(Integer subPoints) {
        this.subPoints = subPoints;
    }

    public Integer getAddPoints() {
        return addPoints;
    }

    public void setAddPoints(Integer addPoints) {
        this.addPoints = addPoints;
    }

    public Integer getPoints() {
        return points;
    }

    public void setPoints(Integer points) {
        this.points = points;
    }

    public LocalDate getDeadlineOffer() {
        return deadlineOffer;
    }

    public void setDeadlineOffer(LocalDate deadlineOffer) {
        this.deadlineOffer = deadlineOffer;
    }

    public String getDescriptionOffer() {
        return descriptionOffer;
    }

    public void setDescriptionOffer(String descriptionOffer) {
        this.descriptionOffer = descriptionOffer;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}