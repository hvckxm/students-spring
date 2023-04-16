package com.students.infrastructure.controllers;

import com.students.domain.Group;
import com.students.interactors.group.CreateGroupInteractor;
import com.students.interactors.group.DeleteGroupInteractor;
import com.students.interactors.group.GetGroupListInteractor;
import com.students.interactors.group.UpdateGroupInteractor;
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
@RequestMapping("/groups")
public class GroupController {
    private final GetGroupListInteractor getGroupListInteractor;
    private final CreateGroupInteractor createGroupInteractor;
    private final UpdateGroupInteractor updateGroupInteractor;
    private final DeleteGroupInteractor deleteGroupInteractor;

    public GroupController(
            GetGroupListInteractor getGroupListInteractor,
            CreateGroupInteractor createGroupInteractor,
            UpdateGroupInteractor updateGroupInteractor,
            DeleteGroupInteractor deleteGroupInteractor
    ) {
        this.getGroupListInteractor = getGroupListInteractor;
        this.createGroupInteractor = createGroupInteractor;
        this.updateGroupInteractor = updateGroupInteractor;
        this.deleteGroupInteractor = deleteGroupInteractor;
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

    @GetMapping("/create/")
    public String create(Model model) {
        model.addAttribute("group", new Group());

        return "pages/groups/create";
    }

    @PostMapping("/")
    public RedirectView store(@ModelAttribute Group group) {
        this.createGroupInteractor.create(group);

        return new RedirectView("/groups/");
    }

    @GetMapping("/{id}/")
    public String edit(@ModelAttribute Group group, Model model) {
        model.addAttribute("group", group);

        return "pages/groups/edit";
    }

    @PutMapping("/{id}/")
    public RedirectView update(@ModelAttribute Group group) {
        this.updateGroupInteractor.update(group);

        return new RedirectView("/groups/");
    }

    @DeleteMapping("/{id}/")
    public RedirectView delete(@ModelAttribute Group group) {
        this.deleteGroupInteractor.delete(group);

        return new RedirectView("/groups/");
    }
}
