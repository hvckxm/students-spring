package com.students.interactors.group.student;

import com.students.domain.Group;
import com.students.domain.Student;
import com.students.domain.StudentRepository;

import java.awt.print.Pageable;
import java.util.List;

public class GetGroupStudentListInteractor {
    private StudentRepository studentRepository;

    public GetGroupStudentListInteractor(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> get(Group group, Pageable pageable) {
        return this.studentRepository.findByGroupPaginated(group, pageable);
    }
}
