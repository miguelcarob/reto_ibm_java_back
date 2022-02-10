package com.group09.movies.dto;


import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

public class NewUserSubscriberDto {

    @NotBlank
    private String usernameUserCinema;

    @NotBlank
    private String passwordUserCinema;

    @NotBlank
    private String nameUserCinema;

    private String surnameUserCinema;

    @Email
    private String emailUserCinema;

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
