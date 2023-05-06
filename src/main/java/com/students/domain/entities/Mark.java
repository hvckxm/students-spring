package com.students.domain.entities;

import com.students.domain.entities.id.MarkId;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@IdClass(MarkId.class)
public class Mark {
    @Id
    @ManyToOne(targetEntity = Student.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "student_id")
    private Student student;
    @Id
    @ManyToOne(targetEntity = Lesson.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "lesson_id")
    private Lesson lesson;
    private int value;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public Mark(Student student, Lesson lesson, int value, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.student = student;
        this.lesson = lesson;
        this.value = value;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Mark() {

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

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public Mark setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;

        return this;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public Mark setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;

        return this;
    }
}
