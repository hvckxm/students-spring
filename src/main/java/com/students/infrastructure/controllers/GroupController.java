package com.students.infrastructure.controllers;

import com.students.domain.Group;
import com.students.interactors.group.GetGroupListInteractor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;

@Controller
@RequestMapping("/groups")
public class GroupController {
    private final GetGroupListInteractor getGroupListInteractor;

    public GroupController(GetGroupListInteractor getGroupListInteractor) {
        this.getGroupListInteractor = getGroupListInteractor;
    }

    @GetMapping("/")
    public String index(Model model, @RequestParam("page") Optional<Integer> page) {
        int currentPage = page.orElse(1);
        Page<Group> groupPage = this.getGroupListInteractor.getPaginated(PageRequest.of(currentPage - 1, 10));
        int totalPages = groupPage.getTotalPages();

        List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPages)
                .boxed()
                .toList();

        model.addAttribute("groupPage", groupPage);
        model.addAttribute("pageNumbers", pageNumbers);

        return "pages/groups/index";
    }

    @GetMapping("/create")
    public String create() {
        return "pages/groups/create";
    }
}
