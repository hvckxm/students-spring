package com.students.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Lesson {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;

    public Lesson(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Lesson() {

    }

    public Long getId() {
        return id;
    }

    public Lesson setId(Long id) {
        this.id = id;

        return this;
    }

    public String getName() {
        return name;
    }

    public Lesson setName(String name) {
        this.name = name;

        return this;
    }
}
