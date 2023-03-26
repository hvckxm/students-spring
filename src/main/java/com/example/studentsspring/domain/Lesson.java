package com.example.studentsspring.domain;

public class Lesson {
    private Long id;
    private String name;

    public Lesson(Long id, String name) {
        this.id = id;
        this.name = name;
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
