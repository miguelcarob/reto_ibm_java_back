package com.group09.movies.dto;

public final class UserAdministrator extends  UserApp{


    public UserAdministrator(UserApp u) {
        super(u.getUsernameUserCinema(), u.getNameUserCinema(), u.getSurnameUserCinema(), u.getEmailUserCinema());
    }
}
