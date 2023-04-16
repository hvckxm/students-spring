package com.students.interactors.group.student.mark;

import com.students.domain.Mark;
import com.students.domain.MarkRepository;
import com.students.domain.Student;

import java.awt.print.Pageable;
import java.util.List;

public class GetStudentMarksListInteractor {
    private MarkRepository markRepository;

    public GetStudentMarksListInteractor(MarkRepository markRepository) {
        this.markRepository = markRepository;
    }

    public List<Mark> getAllStudentMarksPaginated(Student student, Pageable pageable) {
        return this.markRepository.getByStudentPaginated(student, pageable);
    }
}
