package com.group09.movies.entity;

import javax.persistence.*;

@Entity
@Table(name = "cinema")
public class Cinema {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cinema", nullable = false)
    private Integer id;

    @Column(name = "web_cinema", length = 400)
    private String webCinema;

    @Column(name = "adress_cinema", length = 400)
    private String adressCinema;

    @Column(name = "city_cinema", length = 400)
    private String cityCinema;

    @ManyToOne
    @JoinColumn(name = "id_user_cinema")
    private UserCinema idUserCinema;

    public UserCinema getIdUserCinema() {
        return idUserCinema;
    }

    public void setIdUserCinema(UserCinema idUserCinema) {
        this.idUserCinema = idUserCinema;
    }

    public String getCityCinema() {
        return cityCinema;
    }

    public void setCityCinema(String cityCinema) {
        this.cityCinema = cityCinema;
    }

    public String getAdressCinema() {
        return adressCinema;
    }

    public void setAdressCinema(String adressCinema) {
        this.adressCinema = adressCinema;
    }

    public String getWebCinema() {
        return webCinema;
    }

    public void setWebCinema(String webCinema) {
        this.webCinema = webCinema;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}