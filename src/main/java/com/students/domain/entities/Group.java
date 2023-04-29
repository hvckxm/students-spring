package com.students.domain.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import java.util.List;

@Entity
@Table(name = "`groups`")
public class Group {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotBlank
    private String title;
    @OneToMany
    @JoinColumn(name = "student_id", referencedColumnName = "id")
    private List<Student> students;

    public Group(Long id, String title) {
        this.id = id;
        this.title = title;
    }

    public Group() {

    }

    public Long getId() {
        return id;
    }

    public Group setId(Long id) {
        this.id = id;

        return this;
    }

    public String getTitle() {
        return title;
    }

    public Group setTitle(String title) {
        this.title = title;

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
