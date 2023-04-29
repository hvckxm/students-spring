package com.students.interactors.group;

import com.students.domain.entities.Group;
import com.students.infrastructure.repositories.group.GroupRepository;
import org.springframework.stereotype.Service;

@Service
public class DeleteGroupInteractor {
    private final GroupRepository groupRepository;

    public DeleteGroupInteractor(GroupRepository groupRepository) {
        this.groupRepository = groupRepository;
    }

    public void delete(Group group) {
        this.groupRepository.delete(group);
    }
}
