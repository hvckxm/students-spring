package com.students.infrastructure.repositories.mark;

import com.students.domain.entities.Mark;
import com.students.domain.entities.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface MarkRepository extends PagingAndSortingRepository<Mark, Integer>, CrudRepository<Mark, Integer> {
    Page<Mark> findAllByStudent(Student student, Pageable pageable);
}
