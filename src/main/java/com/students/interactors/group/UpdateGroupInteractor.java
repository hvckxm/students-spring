package com.students.interactors.group;

import com.students.domain.Group;
import com.students.infrastructure.repositories.group.GroupRepository;
import org.springframework.stereotype.Service;

@Service
public class UpdateGroupInteractor {
    private final GroupRepository groupRepository;

    public UpdateGroupInteractor(GroupRepository groupRepository) {
        this.groupRepository = groupRepository;
    }

    public void update(Group group) {
        this.groupRepository.save(group);
    }
}
