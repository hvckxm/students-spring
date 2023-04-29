package com.students.interactors.group.journal;

import com.students.domain.Lesson;
import com.students.domain.Mark;
import com.students.domain.Student;
import org.springframework.stereotype.Service;

import java.util.Dictionary;
import java.util.Hashtable;
import java.util.List;
import java.util.Optional;

@Service
public class GroupStudentMarkByLessonInteractor {
    public Dictionary<Student, Dictionary<Lesson, Mark>> studentMarkDictionary(Iterable<Student> students, Iterable<Lesson> lessons) {
        Dictionary<Student, Dictionary<Lesson, Mark>> studentDictionaryDictionary = new Hashtable<>();

        for (Student student : students) {
            Dictionary<Lesson, Mark> lessonMarkDictionary = new Hashtable<>();
            List<Mark> studentMarks = student.getMarks();

            for (Lesson lesson : lessons) {
                Optional<Mark> studentMark = studentMarks.stream().filter(
                        (mark -> lesson.getId().equals(mark.getLesson().getId()))
                ).findAny();

                studentMark.ifPresent(mark -> lessonMarkDictionary.put(lesson, mark));
            }

            studentDictionaryDictionary.put(student, lessonMarkDictionary);
        }

        return studentDictionaryDictionary;
    }
}
