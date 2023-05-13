package com.students.infrastructure.controllers;

import com.students.domain.entities.Group;
import com.students.interactors.group.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.access.prepost.PreAuthorize;
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
    private final ShowGroupInteractor showGroupInteractor;

    public GroupController(
            GetGroupListInteractor getGroupListInteractor,
            CreateGroupInteractor createGroupInteractor,
            UpdateGroupInteractor updateGroupInteractor,
            DeleteGroupInteractor deleteGroupInteractor,
            ShowGroupInteractor showGroupInteractor) {
        this.getGroupListInteractor = getGroupListInteractor;
        this.createGroupInteractor = createGroupInteractor;
        this.updateGroupInteractor = updateGroupInteractor;
        this.deleteGroupInteractor = deleteGroupInteractor;
        this.showGroupInteractor = showGroupInteractor;
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

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @GetMapping("/create/")
    public String create(Model model) {
        model.addAttribute("group", new Group());

        return "pages/groups/create";
    }

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @PostMapping("/")
    public RedirectView store(@ModelAttribute Group group) {
        this.createGroupInteractor.create(group);

        return new RedirectView("/groups/");
    }

    @PreAuthorize("(hasAuthority('ROLE_TEACHER') && authentication.details.group == #model.id) || hasAuthority('ROLE_ADMIN') ")
    @GetMapping("/{id}/")
    public String edit(@PathVariable("id") int id, Model model) {
        Group group = this.showGroupInteractor.get(id);

        model.addAttribute("group", group);

        return "pages/groups/edit";
    }

    @PreAuthorize("(hasAuthority('ROLE_TEACHER') && authentication.details.group == #model.id) || hasAuthority('ROLE_ADMIN')")
    @PutMapping("/{id}/")
    public RedirectView update(@ModelAttribute Group group) {
        this.updateGroupInteractor.update(group);

        return new RedirectView("/groups/");
    }

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @DeleteMapping("/{id}/")
    public RedirectView delete(@ModelAttribute Group group) {
        this.deleteGroupInteractor.delete(group);

        return new RedirectView("/groups/");
    }
}
