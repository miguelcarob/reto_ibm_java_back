package com.group09.movies.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

public class NewUserCinemaDto {

    @NotEmpty(message = "Es necesario colocar el usuario")
    private String usernameUserCinema;

    @NotEmpty(message = "Es necesario colocar un password")
    private String passwordUserCinema;

    @NotEmpty(message = "Es necesario colocar el nombre del usuario")
    private String nameUserCinema;

    private String surnameUserCinema;

    @Email(message = "El Email no es valido")
    @NotEmpty(message = "Es necesario colocar el email ")
    private String emailUserCinema;


    @NotEmpty(message = "Es necesario colocar el Sitio Web ")
    private String web_cinema;

    @NotEmpty(message = "Es necesario colocar la dirección ")
    private String address_cinema;

    @NotEmpty(message = "Es necesario colocar la Ciudad ")
    private String city_cinema;

    public String getWeb_cinema() {
        return web_cinema;
    }

    public void setWeb_cinema(String web_cinema) {
        this.web_cinema = web_cinema;
    }

    public String getAddress_cinema() {
        return address_cinema;
    }

    public void setAddress_cinema(String address_cinema) {
        this.address_cinema = address_cinema;
    }

    public String getCity_cinema() {
        return city_cinema;
    }

    public void setCity_cinema(String city_cinema) {
        this.city_cinema = city_cinema;
    }

    public String getUsernameUserCinema() {
        return usernameUserCinema;
    }

    public void setUsernameUserCinema(String usernameUserCinema) {
        this.usernameUserCinema = usernameUserCinema;
    }

    public String getPasswordUserCinema() {
        return passwordUserCinema;
    }

    public void setPasswordUserCinema(String passwordUserCinema) {
        this.passwordUserCinema = passwordUserCinema;
    }

    public String getNameUserCinema() {
        return nameUserCinema;
    }

    public void setNameUserCinema(String nameUserCinema) {
        this.nameUserCinema = nameUserCinema;
    }

    public String getSurnameUserCinema() {
        return surnameUserCinema;
    }

    public void setSurnameUserCinema(String surnameUserCinema) {
        this.surnameUserCinema = surnameUserCinema;
    }

    public String getEmailUserCinema() {
        return emailUserCinema;
    }

    public void setEmailUserCinema(String emailUserCinema) {
        this.emailUserCinema = emailUserCinema;
    }
}