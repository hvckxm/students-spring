package com.students.infrastructure.repositories.role;

import org.springframework.data.repository.CrudRepository;

import com.students.domain.entities.Role;
import java.util.Optional;

public interface RoleRepository extends CrudRepository<Role, Integer> {
     Optional<Role> findByName(String name);
}
