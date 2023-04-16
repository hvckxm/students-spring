package com.students.domain;

public interface LessonRepository {
    void save(Lesson lesson);

    void remove(Lesson lesson);
}
