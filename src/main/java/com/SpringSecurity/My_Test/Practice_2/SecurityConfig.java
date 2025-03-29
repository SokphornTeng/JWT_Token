package com.SpringSecurity.My_Test.Practice_2;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebSecurity
public class SecurityConfig implements WebMvcConfigurer {


    @Bean
    public UserDetailsService userDetailsService(){
        InMemoryUserDetailsManager inMemory = new InMemoryUserDetailsManager();
        inMemory.createUser(
                User.withDefaultPasswordEncoder()
                        .username("testing")
                        .password("1234567")
                        .roles("ADMIN")
                        .build()
        );
        return inMemory;
    }

    protected void configure(HttpSecurity http){
        http.antMatcher("/")
                .authorizeRequests()
                .anyRequest()
                .hasRole("ADMIN")
                .and()
                .httpBasic();
    }

}
