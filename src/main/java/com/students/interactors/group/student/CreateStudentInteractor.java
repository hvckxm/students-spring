package com.students.interactors.group.student;

import com.students.domain.Student;
import com.students.domain.StudentRepository;

public class CreateStudentInteractor {
    private StudentRepository studentRepository;

    public CreateStudentInteractor(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public void create(Student student) {
        this.studentRepository.save(student);
    }
}
