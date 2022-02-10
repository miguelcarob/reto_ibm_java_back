package com.group09.movies.dto;

import javax.validation.constraints.Future;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

public class NewOfferDTO {

    @NotEmpty(message = "Es necesario colocar la descripcción")
    private String descriptionOffer;

    @Future(message = "Es necesario colocar una fecha futura")
    private LocalDate deadlineOffer;

    @NotNull(message = "Es necesario colocar Los puntos a agregar ")
    private Integer addPoints;

    @NotNull(message = "Es necesario colocar los puntos a restar")
    private Integer subPoints;

    @NotNull(message = "Error en el codigo de la oferta")
    private Integer  totalOffers;

    @NotNull(message = "Error en el codigo del cinema")
    private Integer  idCinema;

    public String getDescriptionOffer() {
        return descriptionOffer;
    }

    public void setDescriptionOffer(String descriptionOffer) {
        this.descriptionOffer = descriptionOffer;
    }

    public LocalDate getDeadlineOffer() {
        return deadlineOffer;
    }

    public void setDeadlineOffer(LocalDate deadlineOffer) {
        this.deadlineOffer = deadlineOffer;
    }

    public Integer getAddPoints() {
        return addPoints;
    }

    public void setAddPoints(Integer addPoints) {
        this.addPoints = addPoints;
    }

    public Integer getSubPoints() {
        return subPoints;
    }

    public void setSubPoints(Integer subPoints) {
        this.subPoints = subPoints;
    }

    public Integer getTotalOffers() {
        return totalOffers;
    }

    public void setTotalOffers(Integer totalOffers) {
        this.totalOffers = totalOffers;
    }



    public Integer getIdCinema() {
        return idCinema;
    }

    public void setIdCinema(Integer id) {
        this.idCinema = id;
    }
}
