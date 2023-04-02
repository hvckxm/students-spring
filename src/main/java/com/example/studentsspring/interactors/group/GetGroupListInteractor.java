package com.example.studentsspring.interactors.group;

import com.example.studentsspring.domain.Group;
import com.example.studentsspring.domain.GroupRepository;

import java.awt.print.Pageable;
import java.util.List;

public class GetGroupListInteractor {
    private GroupRepository groupRepository;

    public GetGroupListInteractor(GroupRepository groupRepository) {
        this.groupRepository = groupRepository;
    }

    public List<Group> getPaginated(Pageable pageable) {
        return this.groupRepository.findAllPaginated(pageable);
    }
}
