package com.example.studentsspring.domain;

import java.awt.print.Pageable;
import java.util.List;

public interface LessonRepository {
    void save(Lesson lesson);

    void remove(Lesson lesson);

    List<Lesson> findAllPaginated(Pageable pageable);
}
