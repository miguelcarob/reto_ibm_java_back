package com.group09.movies;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.time.Duration;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.cors(Customizer.withDefaults())
                .csrf().disable().authorizeRequests().antMatchers("/**").permitAll();
    }


    @Bean
    CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration cc = new CorsConfiguration();
        cc.setAllowedHeaders(Arrays.asList("Origin,Accept", "X-Requested-With", "Content-Type", "Access-Control-Request-Method", "Access-Control-Request-Headers","Authorization"));
        cc.setExposedHeaders(Arrays.asList("Access-Control-Allow-Origin", "Access-Control-Allow-Credentials"));
        cc.setAllowedOrigins(Arrays.asList("/*"));
        cc.setAllowedMethods(Arrays.asList("GET", "POST", "OPTIONS", "PUT","PATCH"));
        cc.setAllowedOrigins(List.of("http://localhost:4200"));
        cc.setMaxAge(Duration.ZERO);
        cc.setAllowCredentials(Boolean.TRUE);
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", cc);
        return source;
    }
    /**
     *
     * first
     *
     * http.authorizeRequests().anyRequest().permitAll();
     *
     *
     *
     * second
     *
     * http
     *         // disabling csrf here, you should enable it before using in production
     *         .csrf().disable()
     *         .authorizeRequests()
     *        // this matcher is working for all GET/POST/... , any URL matching the reg expression
     *             .antMatchers("/**").permitAll()
     *
     *
     *Third
     *
     *
     *     @Override
     *     protected void configure(HttpSecurity http) throws Exception {
     *         http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and().
     *                 authorizeRequests().antMatchers(HttpMethod.GET, "/**").hasAnyRole("ADMIN", "USER")
     *                 .antMatchers(HttpMethod.POST, "/**").hasAnyRole("ADMIN", "USER")
     *                 .antMatchers(HttpMethod.POST, "/**").hasRole("ADMIN")
     *                 .antMatchers(HttpMethod.DELETE, "/**").hasRole("ADMIN").and().
     *                 requestCache().requestCache(new NullRequestCache()).and().
     *                 httpBasic().authenticationEntryPoint(authenticationEntryPoint).and().
     *                 cors().and().
     *                 csrf().disable();
     *     }
     *
     * }
     */
}