package com.group09.movies.entity;

import javax.persistence.*;

@Entity
@Table(name = "user_cinema")
public class UserCinema {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_user_cinema", nullable = false)
    private Integer id;

    @Column(name = "username_user_cinema", length = 100)
    private String usernameUserCinema;

    @Column(name = "password_user_cinema", length = 200)
    private String passwordUserCinema;

    @Column(name = "name_user_cinema", length = 200)
    private String nameUserCinema;

    @Column(name = "surname_user_cinema", length = 200)
    private String surnameUserCinema;

    @Column(name = "email_user_cinema", length = 200)
    private String emailUserCinema;

    @Column(name = "type_user_cinema")
    private Integer typeUserCinema;

    @Column(name = "state_user_cinema")
    private Integer stateUserCinema;

    public Integer getStateUserCinema() {
        return stateUserCinema;
    }

    public void setStateUserCinema(Integer stateUserCinema) {
        this.stateUserCinema = stateUserCinema;
    }

    public Integer getTypeUserCinema() {
        return typeUserCinema;
    }

    public void setTypeUserCinema(Integer typeUserCinema) {
        this.typeUserCinema = typeUserCinema;
    }

    public String getEmailUserCinema() {
        return emailUserCinema;
    }

    public void setEmailUserCinema(String emailUserCinema) {
        this.emailUserCinema = emailUserCinema;
    }

    public String getSurnameUserCinema() {
        return surnameUserCinema;
    }

    public void setSurnameUserCinema(String surnameUserCinema) {
        this.surnameUserCinema = surnameUserCinema;
    }

    public String getNameUserCinema() {
        return nameUserCinema;
    }

    public void setNameUserCinema(String nameUserCinema) {
        this.nameUserCinema = nameUserCinema;
    }

    public String getPasswordUserCinema() {
        return passwordUserCinema;
    }

    public void setPasswordUserCinema(String passwordUserCinema) {
        this.passwordUserCinema = passwordUserCinema;
    }

    public String getUsernameUserCinema() {
        return usernameUserCinema;
    }

    public void setUsernameUserCinema(String usernameUserCinema) {
        this.usernameUserCinema = usernameUserCinema;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}