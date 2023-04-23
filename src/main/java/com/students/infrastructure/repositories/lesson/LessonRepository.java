package com.students.infrastructure.repositories.lesson;

import com.students.domain.Lesson;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface LessonRepository extends PagingAndSortingRepository<Lesson, Integer>, CrudRepository<Lesson, Integer> {
}
