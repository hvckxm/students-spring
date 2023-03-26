package com.example.studentsspring.domain;

import java.awt.print.Pageable;
import java.util.List;

public interface MarkRepository {
    void save(Mark mark);

    void remove(Mark mark);

    List<Mark> getByStudentPaginated(Student student, Pageable pageable);
}
