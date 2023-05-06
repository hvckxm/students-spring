package com.students.infrastructure.validators;

import com.students.infrastructure.validators.contracts.HasPasswordNeedToConfirm;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class PasswordMatchesConstraintValidator
          implements ConstraintValidator<PasswordMatches, HasPasswordNeedToConfirm> {
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
     public void initialize(PasswordMatches constraintAnnotation) {
          ConstraintValidator.super.initialize(constraintAnnotation);
     }

     @Override
     public boolean isValid(HasPasswordNeedToConfirm value, ConstraintValidatorContext context) {
          boolean isValid = value.getPassword().equals(value.getPasswordConfirmation());

          if (isValid) {
               return isValid;
          }

          context.disableDefaultConstraintViolation();
          context.buildConstraintViolationWithTemplate("Passwords don't match")
                    .addPropertyNode("password").addConstraintViolation();

          return isValid;
     }
}
