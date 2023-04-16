package com.students.domain;

import java.awt.print.Pageable;
import java.util.List;

public interface StudentRepository {
    void save(Student student);

    List<Student> findByGroupPaginated(Group group, Pageable pageable);
}
