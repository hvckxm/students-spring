package com.students.domain.entities.id;

import com.students.domain.entities.Lesson;
import com.students.domain.entities.Student;

import java.io.Serializable;

public class MarkId implements Serializable {
    private Student student;
    private Lesson lesson;

    public MarkId(Student student, Lesson lesson) {
        this.student = student;
        this.lesson = lesson;
    }

    public MarkId() {

    }

    public Student getStudent() {
        return student;
    }

    public MarkId setStudent(Student student) {
        this.student = student;

        return this;
    }

    public Lesson getLesson() {
        return lesson;
    }

    public MarkId setLesson(Lesson lesson) {
        this.lesson = lesson;

        return this;
    }
}
