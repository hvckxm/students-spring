package com.students.interactors.lesson;

import com.students.domain.entities.Lesson;
import com.students.infrastructure.repositories.lesson.LessonRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class GetAllLessonsInteractor {
    private final LessonRepository lessonRepository;

    public GetAllLessonsInteractor(LessonRepository lessonRepository) {
        this.lessonRepository = lessonRepository;
    }

    public Page<Lesson> get(Pageable pageable) {
        return this.lessonRepository.findAll(pageable);
    }
}
