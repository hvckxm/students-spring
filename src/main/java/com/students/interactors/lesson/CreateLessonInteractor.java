package com.students.interactors.lesson;

import com.students.domain.Lesson;
import com.students.infrastructure.repositories.lesson.LessonRepository;
import org.springframework.stereotype.Service;

@Service
public class CreateLessonInteractor {
    private final LessonRepository lessonRepository;

    public CreateLessonInteractor(LessonRepository lessonRepository) {
        this.lessonRepository = lessonRepository;
    }

    public void create(Lesson lesson) {
        this.lessonRepository.save(lesson);
    }
}
