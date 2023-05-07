package com.students.infrastructure.security;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.students.domain.entities.Role;
import com.students.infrastructure.repositories.role.RoleRepository;

import jakarta.transaction.Transactional;

@Component
public class SetupDataLoader implements ApplicationListener<ContextRefreshedEvent> {
     boolean alreadySetup = false;

     @Autowired
     private RoleRepository roleRepository;

     @Override
     public void onApplicationEvent(ContextRefreshedEvent event) {
          if (alreadySetup) {
               return;
          }

          createRoleIfNotFound("ROLE_USER");
          createRoleIfNotFound("ROLE_ADMIN");
          createRoleIfNotFound("ROLE_TEACHER");

          alreadySetup = true;
     }

     @Transactional
     Role createRoleIfNotFound(String name) {
          Optional<Role> role = roleRepository.findByName(name);

          if (role.isPresent()) {
               return role.get();
          }

          Role newRole = new Role();
          newRole.setName(name);

          return roleRepository.save(newRole);
     }
}
