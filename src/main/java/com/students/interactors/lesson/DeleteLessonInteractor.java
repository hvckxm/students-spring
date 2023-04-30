package com.students.interactors.lesson;

import com.students.domain.entities.Lesson;
import com.students.infrastructure.repositories.lesson.LessonRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public class DeleteLessonInteractor {
    private final LessonRepository lessonRepository;

    public DeleteLessonInteractor(LessonRepository lessonRepository) {
        this.lessonRepository = lessonRepository;
    }

    public void delete(Lesson lesson) {
        this.lessonRepository.delete(lesson);
    }
}
