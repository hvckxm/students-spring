package com.students.interactors.group.student;

import com.students.domain.Group;
import com.students.domain.Student;
import com.students.domain.StudentRepository;

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
