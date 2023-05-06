package com.students.infrastructure.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {
     @Bean
     public PasswordEncoder passwordEncoder() {
          return new BCryptPasswordEncoder();
     }

     @Bean
     public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
          return http.formLogin(
                    form -> form
                              .loginPage("/login")
                              .permitAll())
                    .logout(logout -> logout.permitAll())
                    .authorizeHttpRequests(
                              authorize -> authorize
                                        .requestMatchers("/", "/registration/")
                                        .permitAll())
                    .build();
     }
}
