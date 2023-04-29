package com.students.infrastructure.controllers;

import com.students.domain.entities.Group;
import com.students.domain.entities.Mark;
import com.students.domain.entities.Student;
import com.students.interactors.group.student.*;
import com.students.interactors.group.student.mark.GetStudentMarksListInteractor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;

@Controller
public class StudentController {
    private final GetGroupStudentListInteractor getGroupStudentListInteractor;
    private final CreateStudentInteractor createStudentInteractor;
    private final UpdateStudentInteractor updateStudentInteractor;
    private final DeleteStudentInteractor deleteStudentInteractor;
    private final ShowStudentInteractor showStudentInteractor;
    private final GetStudentMarksListInteractor getStudentMarksListInteractor;

    public StudentController(
            GetGroupStudentListInteractor getGroupStudentListInteractor,
            CreateStudentInteractor createStudentInteractor,
            UpdateStudentInteractor updateStudentInteractor,
            DeleteStudentInteractor deleteStudentInteractor,
            ShowStudentInteractor showStudentInteractor,
            GetStudentMarksListInteractor getStudentMarksListInteractor
    ) {
        this.getGroupStudentListInteractor = getGroupStudentListInteractor;
        this.createStudentInteractor = createStudentInteractor;
        this.updateStudentInteractor = updateStudentInteractor;
        this.deleteStudentInteractor = deleteStudentInteractor;
        this.showStudentInteractor = showStudentInteractor;
        this.getStudentMarksListInteractor = getStudentMarksListInteractor;
    }

    @GetMapping("/groups/{group}/students/")
    public String index(@PathVariable Group group, Model model, @RequestParam("page") Optional<Integer> page) {
        int currentPage = page.orElse(1);

        Page<Student> studentPage = this.getGroupStudentListInteractor.getPaginated(
                group,
                PageRequest.of(currentPage - 1, 10)
        );
        int totalPages = studentPage.getTotalPages();

        List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPages)
                .boxed()
                .toList();

        model.addAttribute("studentPage", studentPage);
        model.addAttribute("pageNumbers", pageNumbers);
        model.addAttribute("group", group);

        return "pages/groups/students/index";
    }

    @GetMapping("/groups/{group}/students/create/")
    public String create(@PathVariable Group group, Model model) {
        model.addAttribute("student", new Student());
        model.addAttribute("group", group);

        return "pages/groups/students/create";
    }

    @PostMapping("/groups/{group}/students/")
    public RedirectView store(
            @PathVariable Group group,
            @ModelAttribute Student student,
            RedirectAttributes redirectAttributes
    ) {
        this.createStudentInteractor.create(student, group);

        redirectAttributes.addAttribute("group", group.getId());

        return new RedirectView("/groups/{group}/students/");
    }

    @GetMapping("/students/{id}/edit")
    public String edit(
            @PathVariable int id,
            Model model
    ) {
        Student student = this.showStudentInteractor.get(id);

        model.addAttribute("student", student);

        return "pages/groups/students/edit";
    }

    @PutMapping("/students/{id}/")
    public RedirectView update(
            @ModelAttribute Student student,
            RedirectAttributes redirectAttributes
    ) {
        this.updateStudentInteractor.update(student);

        redirectAttributes.addAttribute("student", student);

        return new RedirectView("/students/{student}/");
    }

    @DeleteMapping("/groups/{group}/students/{id}/")
    public RedirectView delete(
            @PathVariable Group group,
            @ModelAttribute Student student,
            RedirectAttributes redirectAttributes
    ) {
        this.deleteStudentInteractor.delete(student);

        redirectAttributes.addAttribute("group", group);

        return new RedirectView("/groups/{group}/students/");
    }

    @GetMapping("/students/{id}/")
    public String show(
            @PathVariable int id,
            @RequestParam("page") Optional<Integer> page,
            Model model
    ) {
        Student student = this.showStudentInteractor.get(id);

        model.addAttribute("student", student);

        int currentPage = page.orElse(1);

        Page<Mark> markPage = this.getStudentMarksListInteractor.getAllStudentMarksPaginated(
                student,
                PageRequest.of(currentPage - 1, 10)
        );

        int totalPages = markPage.getTotalPages();

        List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPages)
                .boxed()
                .toList();

        model.addAttribute("markPage", markPage);
        model.addAttribute("currentPage", currentPage);
        model.addAttribute("totalPages", totalPages);
        model.addAttribute("pageNumbers", pageNumbers);

        return "pages/groups/students/show";
    }
}
