package com.students.interactors.group.student;

import com.students.domain.Student;
import com.students.infrastructure.repositories.student.StudentRepository;
import org.springframework.stereotype.Service;

@Service
public class UpdateStudentInteractor {
    private final StudentRepository studentRepository;

    public UpdateStudentInteractor(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public void update(Student student) {
        this.studentRepository.save(student);
    }
}
