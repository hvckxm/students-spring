package com.students.interactors.group.student.mark;

import com.students.domain.entities.Mark;
import com.students.domain.entities.Student;
import com.students.infrastructure.repositories.mark.MarkRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
@Component
public class GetStudentMarksListInteractor {
    private final MarkRepository markRepository;

    public GetStudentMarksListInteractor(MarkRepository markRepository) {
        this.markRepository = markRepository;
    }

    public Page<Mark> getAllStudentMarksPaginated(Student student, Pageable pageable) {
        return this.markRepository.findAllByStudent(student, pageable);
    }
}
