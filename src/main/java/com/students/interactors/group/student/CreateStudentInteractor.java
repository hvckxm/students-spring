package com.students.interactors.group.student;

import com.students.domain.entities.Group;
import com.students.domain.entities.Student;
import com.students.infrastructure.repositories.student.StudentRepository;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.LocalTime;

@Component
public class CreateStudentInteractor {
    private final StudentRepository studentRepository;

    public CreateStudentInteractor(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public void create(Student student, Group group) {
        student.setGroup(group);
        student.setCreatedAt(LocalDateTime.now());
        student.setUpdatedAt(LocalDateTime.now());

        this.studentRepository.save(student);
    }
}
