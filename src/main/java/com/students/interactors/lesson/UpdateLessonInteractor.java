package com.students.interactors.lesson;

import com.students.domain.entities.Lesson;
import com.students.infrastructure.repositories.lesson.LessonRepository;
import org.springframework.stereotype.Service;

@Service
public class UpdateLessonInteractor {
    private final LessonRepository lessonRepository;

    public UpdateLessonInteractor(LessonRepository lessonRepository) {
        this.lessonRepository = lessonRepository;
    }

    public void update(Lesson lesson) {
        this.lessonRepository.save(lesson);
    }
}
