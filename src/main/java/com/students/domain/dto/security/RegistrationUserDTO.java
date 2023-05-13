package com.students.domain.dto.security;

import com.students.infrastructure.validators.PasswordMatches;
import com.students.infrastructure.validators.UniqueUserEmail;
import com.students.infrastructure.validators.ValidPassword;
import com.students.infrastructure.validators.contracts.HasPasswordNeedToConfirm;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

@PasswordMatches
public class RegistrationUserDTO implements HasPasswordNeedToConfirm {
    @NotBlank
    @NotEmpty
    private String firstName;

    private String middleName;

    @NotBlank
    @NotEmpty
    private String lastName;

    @Email
    @UniqueUserEmail
    @NotBlank
    private String email;

    @NotNull
    @NotEmpty
    @ValidPassword
    private String password;

    @NotNull
    @NotBlank
    @NotEmpty
    private String passwordConfirmation;

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return this.middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getPasswordConfirmation() {
        return this.passwordConfirmation;
    }

    public void setPasswordConfirmation(String passwordConfirmation) {
        this.passwordConfirmation = passwordConfirmation;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
