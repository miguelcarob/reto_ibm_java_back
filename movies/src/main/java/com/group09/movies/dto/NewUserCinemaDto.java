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
    private String webCinema;

    @NotEmpty(message = "Es necesario colocar la dirección ")
    private String adressCinema;

    @NotEmpty(message = "Es necesario colocar la Ciudad ")
    private String cityCinema;

    public String getWebCinema() {
        return webCinema;
    }

    public void setWebCinema(String webCinema) {
        this.webCinema = webCinema;
    }

    public String getAdressCinema() {
        return adressCinema;
    }

    public void setAdressCinema(String adressCinema) {
        this.adressCinema = adressCinema;
    }

    public String getCityCinema() {
        return cityCinema;
    }

    public void setCityCinema(String cityCinema) {
        this.cityCinema = cityCinema;
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