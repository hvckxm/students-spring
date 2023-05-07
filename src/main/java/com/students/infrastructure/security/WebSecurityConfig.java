package com.students.infrastructure.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.hierarchicalroles.RoleHierarchy;
import org.springframework.security.access.hierarchicalroles.RoleHierarchyImpl;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import com.students.infrastructure.services.CustomUserDetailService;

import jakarta.annotation.Resource;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {
     @Resource
     private CustomUserDetailService customUserDetailService;

     @Bean
     public DaoAuthenticationProvider authProvider() {
          DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
          authProvider.setUserDetailsService(customUserDetailService);
          authProvider.setPasswordEncoder(passwordEncoder());
          return authProvider;
     }

     @Bean
     public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
          return http.formLogin(
                    form -> form
                              .loginPage("/login")
                              .successForwardUrl("/")
                              .defaultSuccessUrl("/")
                              .failureForwardUrl("/login?error")
                              .permitAll())
                    .logout(logout -> logout.permitAll())
                    .authorizeHttpRequests(
                              authorize -> authorize
                                        .requestMatchers("/", "/registration/")
                                        .permitAll()
                                        .requestMatchers("/**").authenticated())
                    .build();
     }

     @Bean
     public PasswordEncoder passwordEncoder() {
          return new BCryptPasswordEncoder();
     }

     @Bean
     public RoleHierarchy roleHierarchy() {
          RoleHierarchyImpl roleHierarchy = new RoleHierarchyImpl();
          String hierarchy = "ROLE_ADMIN > ROLE_TEACHER \n ROLE_TEACHER > ROLE_USER";
          roleHierarchy.setHierarchy(hierarchy);
          return roleHierarchy;
     }
}
