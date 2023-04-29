package com.students.interactors.group.student;

import com.students.domain.entities.Group;
import com.students.domain.entities.Student;
import com.students.infrastructure.repositories.student.StudentRepository;
import org.springframework.stereotype.Service;

@Service
public class CreateStudentInteractor {
    private final StudentRepository studentRepository;

    public CreateStudentInteractor(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public void create(Student student, Group group) {
        student.setGroup(group);

        this.studentRepository.save(student);
    }
}
