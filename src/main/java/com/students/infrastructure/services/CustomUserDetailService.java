package com.students.infrastructure.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.students.domain.entities.User;
import com.students.infrastructure.repositories.user.UserRepository;
import com.students.security.settings.CustomUserDetails;

@Service
public class CustomUserDetailService implements UserDetailsService {
     @Autowired
     private UserRepository userRepository;

     @Override
     public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
          Optional<User> user = this.userRepository.findByEmail(username);

          if (user.isEmpty()) {
               throw new UsernameNotFoundException("Not found");
          }

          return new CustomUserDetails(user.get());
     }

}
