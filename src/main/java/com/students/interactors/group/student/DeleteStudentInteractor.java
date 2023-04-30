package com.students.interactors.group.student;

import com.students.domain.entities.Student;
import com.students.infrastructure.repositories.student.StudentRepository;
import org.springframework.stereotype.Component;

@Component
public class DeleteStudentInteractor {
    private final StudentRepository studentRepository;

    public DeleteStudentInteractor(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public void delete(Student student) {
        this.studentRepository.delete(student);
    }
}
