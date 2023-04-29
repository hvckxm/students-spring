package com.students.infrastructure.controllers;

import com.students.domain.entities.Group;
import com.students.domain.entities.Lesson;
import com.students.domain.entities.Mark;
import com.students.domain.entities.Student;
import com.students.interactors.group.journal.GetAllJournalLessonsInteractor;
import com.students.interactors.group.journal.GetStudentsWithMarksInteractor;
import com.students.interactors.group.journal.GroupStudentMarkByLessonInteractor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Dictionary;

@Controller
@RequestMapping("/groups/{id}/journal")
public class JournalController {
    private final GetStudentsWithMarksInteractor getStudentsWithMarksInteractor;
    private final GetAllJournalLessonsInteractor getAllJournalLessonsInteractor;
    private final GroupStudentMarkByLessonInteractor groupStudentMarkByLessonInteractor;

    public JournalController(
            GetStudentsWithMarksInteractor getStudentsWithMarksInteractor,
            GetAllJournalLessonsInteractor getAllJournalLessonsInteractor,
            GroupStudentMarkByLessonInteractor groupStudentMarkByLessonInteractor
    ) {
        this.getStudentsWithMarksInteractor = getStudentsWithMarksInteractor;
        this.getAllJournalLessonsInteractor = getAllJournalLessonsInteractor;
        this.groupStudentMarkByLessonInteractor = groupStudentMarkByLessonInteractor;
    }

    @GetMapping("/")
    public String index(Model ui, @ModelAttribute Group group) {
        Iterable<Student> students = this.getStudentsWithMarksInteractor.get(group);
        Iterable<Lesson> lessons = this.getAllJournalLessonsInteractor.get();
        Dictionary<Student, Dictionary<Lesson, Mark>> studentDictionaryDictionary = this.groupStudentMarkByLessonInteractor.studentMarkDictionary(students, lessons);

        ui.addAttribute("group", group);
        ui.addAttribute("students", students);
        ui.addAttribute("lessons", lessons);
        ui.addAttribute("studentDictionaryDictionary", studentDictionaryDictionary);

        return "pages/groups/journal/index";
    }
}
