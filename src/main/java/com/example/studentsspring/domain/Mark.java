package com.example.studentsspring.domain;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class Mark {
    private Student student;
    private Lesson lesson;
    @Max(5)
    @Min(2)
    private int value;
    @DateTimeFormat
    private Date createdAt;
    @DateTimeFormat
    private Date updatedAt;

    public Mark(Student student, Lesson lesson, int value, Date createdAt, Date updatedAt) {
        this.student = student;
        this.lesson = lesson;
        this.value = value;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Student getStudent() {
        return student;
    }

    public Mark setStudent(Student student) {
        this.student = student;

        return this;
    }

    public Lesson getLesson() {
        return lesson;
    }

    public Mark setLesson(Lesson lesson) {
        this.lesson = lesson;

        return this;
    }

    public int getValue() {
        return value;
    }

    public Mark setValue(int value) {
        this.value = value;

        return this;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public Mark setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;

        return this;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public Mark setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;

        return this;
    }
}
