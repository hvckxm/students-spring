package com.example.studentsspring.domain;

import jakarta.validation.constraints.NotBlank;

import java.util.List;

public class Group {
    private Long id;
    @NotBlank
    private String name;
    private List<Student> students;

    public Group(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public Group setId(Long id) {
        this.id = id;

        return this;
    }

    public String getName() {
        return name;
    }

    public Group setName(String name) {
        this.name = name;

        return this;
    }

    public List<Student> getStudents() {
        return this.students;
    }

    public Group addStudent(Student student) {
        this.students.add(student);

        return this;
    }
}
