package com.example.studentsspring.interactors;

import com.example.studentsspring.domain.Mark;
import com.example.studentsspring.domain.MarkRepository;
import com.example.studentsspring.domain.Student;

import java.awt.print.Pageable;
import java.util.List;

public class GetAllStudentMarksInteractor {
    private MarkRepository markRepository;

    public GetAllStudentMarksInteractor(MarkRepository markRepository) {
        this.markRepository = markRepository;
    }

    public List<Mark> getAllStudentMarksPaginated(Student student, Pageable pageable) {
        return this.markRepository.getByStudentPaginated(student, pageable);
    }
}
