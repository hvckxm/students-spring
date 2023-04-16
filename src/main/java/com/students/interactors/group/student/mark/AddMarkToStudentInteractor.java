package com.students.interactors.group.student.mark;

import com.students.domain.Mark;
import com.students.domain.MarkRepository;
import com.students.domain.Student;

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
