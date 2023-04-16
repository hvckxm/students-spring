package com.students.interactors.group;

import com.students.domain.Group;
import com.students.domain.GroupRepository;

public class CreateGroupInteractor {
    private final GroupRepository groupRepository;

    public CreateGroupInteractor(GroupRepository groupRepository) {
        this.groupRepository = groupRepository;
    }

    public void create(Group group) {
        this.groupRepository.save(group);
    }
}
