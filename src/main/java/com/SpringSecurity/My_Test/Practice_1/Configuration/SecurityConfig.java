package com.SpringSecurity.My_Test.Practice_1.Configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
    @Bean
    public UserDetailsService userDetailsService(){
        UserDetails userNormal = User.withUsername("Sokphorn")
                .password(passwordEncoder().encode("1234567"))
                .roles("NORMAL")
                .build();
        UserDetails userAdmin = User.withUsername("Soklin")
                .password(passwordEncoder().encode("12345678"))
                .roles("ADMIN")
                .build();
        InMemoryUserDetailsManager inMemoryLocal = new InMemoryUserDetailsManager();
        inMemoryLocal.createUser(userNormal);
        inMemoryLocal.createUser(userAdmin);
        return inMemoryLocal;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf(c -> c.disable())
                .authorizeHttpRequests(
                        auth -> auth
                                .requestMatchers("/admin")
                                .hasRole("ADMIN")
                                .requestMatchers("/user")
                                .hasRole("NORMAL")
                                .requestMatchers("/public")
                                .permitAll()
                                .anyRequest()
                                .authenticated()
                )

                .formLogin(f -> f
                        .loginPage("/login")
                        .defaultSuccessUrl("/", true)
                        .permitAll()
                )
                .logout(l -> l
                        .logoutUrl("/logout")
                        .logoutSuccessUrl("/logout?logout")
                        .permitAll()
                );
        return http.build();
    }


}
