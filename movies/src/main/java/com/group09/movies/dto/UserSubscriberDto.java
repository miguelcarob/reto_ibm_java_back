package com.group09.movies.dto;

public class UserSubscriberDto extends UserAppDto {

    private  int current_points;


    public UserSubscriberDto(UserAppDto u) {
        super(u.getUsernameUserCinema(), u.getNameUserCinema(), u.getSurnameUserCinema(), u.getEmailUserCinema());
    }
    public int getCurrent_points() {
        return current_points;
    }

    public void setCurrent_points(int current_points) {
        this.current_points = current_points;
    }
}
