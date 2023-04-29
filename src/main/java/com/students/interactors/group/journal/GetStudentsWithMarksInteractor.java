package com.students.interactors.group.journal;

import com.students.domain.entities.Group;
import com.students.domain.entities.Student;
import com.students.infrastructure.repositories.student.StudentRepository;
import org.springframework.stereotype.Service;

@Service
public class GetStudentsWithMarksInteractor {
    private final StudentRepository studentRepository;

    public GetStudentsWithMarksInteractor(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Iterable<Student> get(Group group) {
        return this.studentRepository.findAllByGroup(group);
    }
}
