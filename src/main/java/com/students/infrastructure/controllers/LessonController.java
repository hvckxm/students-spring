package com.students.infrastructure.controllers;

import com.students.domain.entities.Lesson;
import com.students.interactors.lesson.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;

@Controller
@RequestMapping("/lessons")
public class LessonController {
    private final GetAllLessonsInteractor getAllLessonsInteractor;
    private final CreateLessonInteractor createLessonInteractor;
    private final UpdateLessonInteractor updateLessonInteractor;
    private final DeleteLessonInteractor deleteLessonInteractor;
    private final GetLessonInfoByIdInteractor getLessonInfoByIdInteractor;

    public LessonController(
            GetAllLessonsInteractor getAllLessonsInteractor,
            CreateLessonInteractor createLessonInteractor,
            UpdateLessonInteractor updateLessonInteractor,
            DeleteLessonInteractor deleteLessonInteractor,
            GetLessonInfoByIdInteractor getLessonInfoByIdInteractor
    ) {
        this.getAllLessonsInteractor = getAllLessonsInteractor;
        this.createLessonInteractor = createLessonInteractor;
        this.updateLessonInteractor = updateLessonInteractor;
        this.deleteLessonInteractor = deleteLessonInteractor;
        this.getLessonInfoByIdInteractor = getLessonInfoByIdInteractor;
    }

    @GetMapping("/")
    public String index(Model model, @RequestParam("page") Optional<Integer> page) {
        int currentPage = page.orElse(1);
        Page<Lesson> lessonPage = this.getAllLessonsInteractor.get(PageRequest.of(currentPage - 1, 10));
        int totalPages = lessonPage.getTotalPages();

        List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPages)
                .boxed()
                .toList();

        model.addAttribute("lessonPage", lessonPage);
        model.addAttribute("pageNumbers", pageNumbers);

        return "pages/lessons/index";
    }

    @GetMapping("/create/")
    public String create(Model model) {
        model.addAttribute("lesson", new Lesson());

        return "pages/lessons/create";
    }

    @PostMapping("/")
    public RedirectView store(@ModelAttribute Lesson lesson) {
        this.createLessonInteractor.create(lesson);

        return new RedirectView("/lessons/");
    }

    @GetMapping("/{id}/")
    public String edit(@PathVariable("id") int id, Model model) {
        Lesson lesson = this.getLessonInfoByIdInteractor.get(id);

        model.addAttribute("lesson", lesson);

        return "pages/lessons/edit";
    }

    @PutMapping("/{id}/")
    public RedirectView update(@ModelAttribute Lesson lesson) {
        this.updateLessonInteractor.update(lesson);

        return new RedirectView("/lessons/");
    }

    @DeleteMapping("/{id}/")
    public RedirectView delete(@ModelAttribute Lesson lesson) {
        this.deleteLessonInteractor.delete(lesson);

        return new RedirectView("/lessons/");
    }
}
