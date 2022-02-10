package com.group09.movies;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable().authorizeRequests().antMatchers("/**").permitAll();
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