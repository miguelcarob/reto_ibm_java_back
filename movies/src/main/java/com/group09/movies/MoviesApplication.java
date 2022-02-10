package com.group09.movies;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class MoviesApplication {



    public static void main(String[] args) {
        SpringApplication.run(MoviesApplication.class, args);
    }

}
