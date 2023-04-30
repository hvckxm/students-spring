package com.students.interactors.group.student.mark;

import com.students.domain.entities.Mark;
import com.students.domain.entities.Student;
import com.students.infrastructure.repositories.mark.MarkRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Component
public class AddMarkToStudentInteractor {
    private final MarkRepository markRepository;

    public AddMarkToStudentInteractor(MarkRepository markRepository) {
        this.markRepository = markRepository;
    }

    public void addMarkToStudent(Student student, Mark mark) {
        mark.setStudent(student);
        mark.setCreatedAt(LocalDateTime.now());
        mark.setUpdatedAt(LocalDateTime.now());

        this.markRepository.save(mark);
    }
}
