package com.group09.movies.dto;

public class UserSubscriber extends UserApp{

    private  int current_points;


    public UserSubscriber(UserApp u) {
        super(u.getUsernameUserCinema(), u.getNameUserCinema(), u.getSurnameUserCinema(), u.getEmailUserCinema());
    }
    public int getCurrent_points() {
        return current_points;
    }

    public void setCurrent_points(int current_points) {
        this.current_points = current_points;
    }
}
