package com.students.interactors.group.student.mark;

import com.students.domain.entities.Lesson;
import com.students.infrastructure.repositories.lesson.LessonRepository;
import org.springframework.stereotype.Service;

@Service
public class GetAllLessonInteractor {
    private final LessonRepository lessonRepository;

    public GetAllLessonInteractor(LessonRepository lessonRepository) {
        this.lessonRepository = lessonRepository;
    }

    public Iterable<Lesson> get() {
        return this.lessonRepository.findAll();
    }
}
