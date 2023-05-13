package com.students.security.settings;

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
     public void createRoleIfNotFound(String name) {
          Optional<Role> role = roleRepository.findByName(name);

          if (role.isPresent()) {
               return;
          }

          Role newRole = new Role();
          newRole.setName(name);

          roleRepository.save(newRole);
     }
}
