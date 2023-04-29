package com.students.infrastructure.repositories.student;

import com.students.domain.entities.Group;
import com.students.domain.entities.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface StudentRepository extends PagingAndSortingRepository<Student, Integer>, CrudRepository<Student, Integer> {
    Page<Student> findAllByGroup(Group group, Pageable pageable);
    Iterable<Student> findAllByGroup(Group group);
}
