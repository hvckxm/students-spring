package com.students.interactors.security;

import java.time.LocalDateTime;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.students.domain.dto.security.RegistrationUserDTO;
import com.students.domain.entities.User;
import com.students.infrastructure.repositories.user.UserRepository;

@Component
public class UserRegistrationInteractor {
     private final UserRepository userRepository;
     private final PasswordEncoder passwordEncoder;

     public UserRegistrationInteractor(UserRepository userRepository, PasswordEncoder passwordEncoder) {
          this.userRepository = userRepository;
          this.passwordEncoder = passwordEncoder;
     }

     public void register(RegistrationUserDTO registrationUserDTO) {
          User user = new User();

          user.setFirstName(registrationUserDTO.getFirstName());
          user.setLastName(registrationUserDTO.getLastName());
          user.setMiddleName(registrationUserDTO.getMiddleName());
          user.setEmail(registrationUserDTO.getEmail());

          user.setPassword(this.passwordEncoder.encode(registrationUserDTO.getPassword()));

          user.setCreatedAt(LocalDateTime.now());
          user.setUpdatedAt(LocalDateTime.now());

          this.userRepository.save(user);
     }
}
