package com.students.interactors.group.journal;

import com.students.domain.entities.Lesson;
import com.students.infrastructure.repositories.lesson.LessonRepository;
import org.springframework.stereotype.Service;

@Service
public class GetAllJournalLessonsInteractor {
    private final LessonRepository lessonRepository;

    public GetAllJournalLessonsInteractor(LessonRepository lessonRepository) {
        this.lessonRepository = lessonRepository;
    }

    public Iterable<Lesson> get() {
        return this.lessonRepository.findAll();
    }
}
