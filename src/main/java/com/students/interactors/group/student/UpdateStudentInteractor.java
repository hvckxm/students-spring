package com.students.interactors.group.student;

import com.students.domain.entities.Student;
import com.students.infrastructure.repositories.student.StudentRepository;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class UpdateStudentInteractor {
    private final StudentRepository studentRepository;

    public UpdateStudentInteractor(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public void update(Student student) {
        student.setUpdatedAt(LocalDateTime.now());

        this.studentRepository.save(student);
    }
}
