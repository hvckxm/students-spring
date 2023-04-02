package com.example.studentsspring.interactors.group;

import com.example.studentsspring.domain.Group;
import com.example.studentsspring.domain.GroupRepository;

public class CreateGroupInteractor {
    private GroupRepository groupRepository;

    public CreateGroupInteractor(GroupRepository groupRepository) {
        this.groupRepository = groupRepository;
    }

    public void create(Group group) {
        this.groupRepository.save(group);
    }
}
