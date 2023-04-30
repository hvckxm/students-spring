package com.students.interactors.group;

import com.students.domain.entities.Group;
import com.students.infrastructure.repositories.group.GroupRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

@Component
public class GetGroupListInteractor {
    private final GroupRepository groupRepository;

    public GetGroupListInteractor(GroupRepository groupRepository) {
        this.groupRepository = groupRepository;
    }

    public Page<Group> getPaginated(Pageable pageable) {
        return this.groupRepository.findAll(pageable);
    }
}
