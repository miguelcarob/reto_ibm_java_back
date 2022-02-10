package com.group09.movies.dto;

public class UserCinemaDto extends UserApp{


    private String web_cinema;
    private String address_cinema;
    private String city_cinema;

    public UserCinemaDto(UserApp u) {
        super(u.getUsernameUserCinema(), u.getNameUserCinema(), u.getSurnameUserCinema(), u.getEmailUserCinema());
    }

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
}
