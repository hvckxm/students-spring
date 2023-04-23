package com.students.interactors.lesson;

import com.students.domain.Lesson;
import com.students.infrastructure.repositories.lesson.LessonRepository;
import org.springframework.stereotype.Service;

@Service
public class GetLessonInfoByIdInteractor {
    private final LessonRepository lessonRepository;

    public GetLessonInfoByIdInteractor(LessonRepository lessonRepository) {
        this.lessonRepository = lessonRepository;
    }

    public Lesson get(int id) {
        return this.lessonRepository.findById(id).get();
    }
}
