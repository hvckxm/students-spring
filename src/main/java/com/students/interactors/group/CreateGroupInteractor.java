package com.students.interactors.group;

import com.students.domain.entities.Group;
import com.students.infrastructure.repositories.group.GroupRepository;
import org.springframework.stereotype.Component;

@Component
public class CreateGroupInteractor {
    private final GroupRepository groupRepository;

    public CreateGroupInteractor(GroupRepository groupRepository) {
        this.groupRepository = groupRepository;
    }

    public void create(Group group) {
        this.groupRepository.save(group);
    }
}
