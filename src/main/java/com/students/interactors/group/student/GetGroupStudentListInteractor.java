package com.students.interactors.group.student;

import com.students.domain.entities.Group;
import com.students.domain.entities.Student;
import com.students.infrastructure.repositories.student.StudentRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class GetGroupStudentListInteractor {
    private final StudentRepository studentRepository;

    public GetGroupStudentListInteractor(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Page<Student> getPaginated(Group group, Pageable pageable) {
        return this.studentRepository.findAllByGroup(group, pageable);
    }
}
