package com.example.studentsspring.domain;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class Student {
    private Long id;
    @NotBlank
    private String firstName;
    private String middleName;
    @NotBlank
    private String lastName;
    @Email
    private String email;
    private String password;
    private Group group;
    @DateTimeFormat
    private Date createdAt;
    @DateTimeFormat
    private Date updatedAt;
    private Date deletedAt;

    public Student(Long id, String firstName, String middleName, String lastName, String email) {
        this.id = id;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public Student setId(Long id) {
        this.id = id;

        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public Student setFirstName(String firstName) {
        this.firstName = firstName;

        return this;
    }

    public String getMiddleName() {
        return middleName;
    }

    public Student setMiddleName(String middleName) {
        this.middleName = middleName;

        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public Student setLastName(String lastName) {
        this.lastName = lastName;

        return this;
    }

    public String getEmail() {
        return email;
    }

    public Student setEmail(String email) {
        this.email = email;

        return this;
    }

    public Group getGroup() {
        return group;
    }

    public Student setGroup(Group group) {
        this.group = group;

        return this;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public Student setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;

        return this;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public Student setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;

        return this;
    }

    public Date getDeletedAt() {
        return deletedAt;
    }

    public Student setDeletedAt(Date deletedAt) {
        this.deletedAt = deletedAt;

        return this;
    }
}
