package com.group09.movies.dto;

public final class UserAdministratorDto extends UserAppDto {



    public UserAdministratorDto(UserAppDto u) {
        super(u.getUsernameUserCinema(), u.getNameUserCinema(), u.getSurnameUserCinema(), u.getEmailUserCinema());
    }
}
