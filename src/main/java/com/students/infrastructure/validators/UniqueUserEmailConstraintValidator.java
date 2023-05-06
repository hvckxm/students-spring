package com.students.infrastructure.validators;

import org.springframework.beans.factory.annotation.Autowired;

import com.students.infrastructure.repositories.user.UserRepository;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class UniqueUserEmailConstraintValidator implements ConstraintValidator<UniqueUserEmail, String> {
     @Autowired
     private UserRepository userRepository;

     /**
      * Initializes the validator in preparation for
      * calls.
      * The constraint annotation for a given constraint declaration
      * is passed.
      * <p>
      * This method is guaranteed to be called before any use of this instance for
      * validation.
      * <p>
      * The default implementation is a no-op.
      *
      * @param constraintAnnotation annotation instance for a given constraint
      *                             declaration
      */
     @Override
     public void initialize(UniqueUserEmail constraintAnnotation) {
          ConstraintValidator.super.initialize(constraintAnnotation);
     }

     @Override
     public boolean isValid(String value, ConstraintValidatorContext context) {
          return this.userRepository.findByEmail(value).isEmpty();
     }
}
