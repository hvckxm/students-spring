package com.students.interactors.group.student.mark;

import com.students.domain.entities.Mark;
import com.students.domain.entities.Student;
import com.students.infrastructure.repositories.mark.MarkRepository;
import org.springframework.stereotype.Service;

@Service
public class AddMarkToStudentInteractor {
    private final MarkRepository markRepository;

    public AddMarkToStudentInteractor(MarkRepository markRepository) {
        this.markRepository = markRepository;
    }

    public void addMarkToStudent(Student student, Mark mark) {
        mark.setStudent(student);

        this.markRepository.save(mark);
    }
}
