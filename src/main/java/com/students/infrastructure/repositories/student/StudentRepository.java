package com.students.infrastructure.repositories.student;

import com.students.domain.Group;
import com.students.domain.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface StudentRepository extends PagingAndSortingRepository<Student, Integer>, CrudRepository<Student, Integer> {
    Page<Student> findAllByGroup(Group group, Pageable pageable);
}
