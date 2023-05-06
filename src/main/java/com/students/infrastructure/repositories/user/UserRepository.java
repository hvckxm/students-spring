package com.students.infrastructure.repositories.user;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.students.domain.entities.User;

public interface UserRepository extends CrudRepository<User, Integer> {
     public Optional<User> findByEmail(String email);
}
