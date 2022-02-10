package com.group09.movies.dto;

public class UserApp {
    private String usernameUserCinema;
    private String nameUserCinema;
    private String surnameUserCinema;
    private String emailUserCinema;
    private int TypeUser;

    public UserApp(String usernameUserCinema, String nameUserCinema, String surnameUserCinema, String emailUserCinema) {
        this.usernameUserCinema = usernameUserCinema;
        this.nameUserCinema = nameUserCinema;
        this.surnameUserCinema = surnameUserCinema;
        this.emailUserCinema = emailUserCinema;
    }



    public int getTypeUser() {
        return TypeUser;
    }

    public void setTypeUser(int typeUser) {
        TypeUser = typeUser;
    }




    public String getUsernameUserCinema() {
        return usernameUserCinema;
    }

    public void setUsernameUserCinema(String usernameUserCinema) {
        this.usernameUserCinema = usernameUserCinema;
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
