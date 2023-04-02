package com.example.studentsspring.interactors.group.student;

import com.example.studentsspring.domain.Group;
import com.example.studentsspring.domain.Student;
import com.example.studentsspring.domain.StudentRepository;

public class AddStudentToGroupInteractor {
    private StudentRepository studentRepository;

    public AddStudentToGroupInteractor(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public void add(Student student, Group group) {
        student.setGroup(group);

        this.studentRepository.save(student);
    }
}
