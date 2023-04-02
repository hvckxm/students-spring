package com.example.studentsspring.interactors.group.student;

import com.example.studentsspring.domain.Group;
import com.example.studentsspring.domain.Student;
import com.example.studentsspring.domain.StudentRepository;

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
