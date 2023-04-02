package com.example.studentsspring.interactors.group.student;

import com.example.studentsspring.domain.Student;
import com.example.studentsspring.domain.StudentRepository;

public class CreateStudentInteractor {
    private StudentRepository studentRepository;

    public CreateStudentInteractor(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public void create(Student student) {
        this.studentRepository.save(student);
    }
}
