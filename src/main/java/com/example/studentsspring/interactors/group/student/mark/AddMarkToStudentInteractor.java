package com.example.studentsspring.interactors.group.student.mark;

import com.example.studentsspring.domain.Mark;
import com.example.studentsspring.domain.MarkRepository;
import com.example.studentsspring.domain.Student;

public class AddMarkToStudentInteractor {
    private MarkRepository markRepository;

    public AddMarkToStudentInteractor(MarkRepository markRepository) {
        this.markRepository = markRepository;
    }

    public void addMarkToStudent(Student student, Mark mark) {
        mark.setStudent(student);

        this.markRepository.save(mark);
    }
}
