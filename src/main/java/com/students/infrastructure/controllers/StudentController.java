package com.students.infrastructure.controllers;

import com.students.domain.Group;
import com.students.domain.Mark;
import com.students.domain.Student;
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
@RequestMapping("/groups/{group}/students")
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

    @GetMapping("/")
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

    @GetMapping("/create/")
    public String create(@PathVariable Group group, Model model) {
        model.addAttribute("student", new Student());
        model.addAttribute("group", group);

        return "pages/groups/students/create";
    }

    @PostMapping("/")
    public RedirectView store(
            @PathVariable Group group,
            @ModelAttribute Student student,
            RedirectAttributes redirectAttributes
    ) {
        this.createStudentInteractor.create(student, group);

        redirectAttributes.addAttribute("group", group.getId());

        return new RedirectView("/groups/{group}/students/");
    }

    @GetMapping("/{id}/edit")
    public String edit(
            @PathVariable Group group,
            @PathVariable int id,
            Model model
    ) {
        Student student = this.showStudentInteractor.get(id);

        model.addAttribute("group", group);
        model.addAttribute("student", student);

        return "pages/groups/students/edit";
    }

    @PutMapping("/{id}/")
    public RedirectView update(
            @PathVariable Group group,
            @ModelAttribute Student student,
            RedirectAttributes redirectAttributes
    ) {
        this.updateStudentInteractor.update(student);

        redirectAttributes.addAttribute("group", group);

        return new RedirectView("/groups/{group}/students/");
    }

    @DeleteMapping("/{id}/")
    public RedirectView delete(
            @PathVariable Group group,
            @ModelAttribute Student student,
            RedirectAttributes redirectAttributes
    ) {
        this.deleteStudentInteractor.delete(student);

        redirectAttributes.addAttribute("group", group);

        return new RedirectView("/groups/{group}/students/");
    }

    @GetMapping("/{id}/")
    public String show(
            @PathVariable Group group,
            @PathVariable int id,
            @RequestParam("page") Optional<Integer> page,
            Model model
    ) {
        Student student = this.showStudentInteractor.get(id);

        model.addAttribute("group", group);
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

        return "pages/groups/students/show";
    }
}
