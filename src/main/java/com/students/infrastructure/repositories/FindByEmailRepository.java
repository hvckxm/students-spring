package com.students.infrastructure.repositories;

import java.util.Optional;

public interface FindByEmailRepository<T> {
     public Optional<T> findByEmail(String email);
}
