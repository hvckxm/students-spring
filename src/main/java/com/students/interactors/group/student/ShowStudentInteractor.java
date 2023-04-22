package com.students.interactors.group.student;

import com.students.domain.Student;
import com.students.infrastructure.repositories.student.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ShowStudentInteractor {
    private final StudentRepository studentRepository;

    public ShowStudentInteractor(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Student get(int id) {
        return this.studentRepository.findById(id).get();
    }
}
