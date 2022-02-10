package com.group09.movies.dto;

import javax.validation.constraints.NotBlank;

public class UserCinemaLoginDto {


    @NotBlank
    private String usernameUserCinema;
    @NotBlank
    private String passwordUserCinema;

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



}
