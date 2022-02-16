package com.group09.movies.dto;

public class UserAppDto {
    private String usernameUserCinema;
    private String nameUserCinema;
    private String surnameUserCinema;
    private String emailUserCinema;
    private int typeUser;
    private int user_table;

    public int getUser_table() {
        return user_table;
    }

    public void setUser_table(int user_table) {
        this.user_table = user_table;
    }

    public UserAppDto(String usernameUserCinema, String nameUserCinema, String surnameUserCinema, String emailUserCinema) {
        this.usernameUserCinema = usernameUserCinema;
        this.nameUserCinema = nameUserCinema;
        this.surnameUserCinema = surnameUserCinema;
        this.emailUserCinema = emailUserCinema;
    }



    public int getTypeUser() {
        return typeUser;
    }

    public void setTypeUser(int typeUser) {
        this.typeUser = typeUser;
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
