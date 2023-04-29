package com.students.infrastructure.controllers;

import com.students.domain.Lesson;
import com.students.domain.Mark;
import com.students.domain.Student;
import com.students.interactors.group.student.mark.AddMarkToStudentInteractor;
import com.students.interactors.group.student.mark.GetAllLessonInteractor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequestMapping("/students/{student}/marks")
public class MarkController {
    private final GetAllLessonInteractor getAllLessonInteractor;
    private final AddMarkToStudentInteractor addMarkToStudentInteractor;

    public MarkController(GetAllLessonInteractor getAllLessonInteractor, AddMarkToStudentInteractor addMarkToStudentInteractor) {
        this.getAllLessonInteractor = getAllLessonInteractor;
        this.addMarkToStudentInteractor = addMarkToStudentInteractor;
    }

    @GetMapping("/create/")
    public String create(@PathVariable("student") Student student, Model model) {
        model.addAttribute("mark", new Mark());
        model.addAttribute("student", student);

        Iterable<Lesson> lessons = this.getAllLessonInteractor.get();

        model.addAttribute("lessons", lessons);

        return "pages/groups/students/marks/create";
    }

    public RedirectView store(@PathVariable("student") Student student, @ModelAttribute Mark mark) {
        this.addMarkToStudentInteractor.addMarkToStudent(student, mark);

        return new RedirectView("/students/{student}/");
    }
}
