package com.example.studentsspring.interactors.group.student.mark;

import com.example.studentsspring.domain.Mark;
import com.example.studentsspring.domain.MarkRepository;
import com.example.studentsspring.domain.Student;

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
