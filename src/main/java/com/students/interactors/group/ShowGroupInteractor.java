package com.students.interactors.group;

import com.students.domain.Group;
import com.students.infrastructure.repositories.group.GroupRepository;
import org.springframework.stereotype.Service;

@Service
public class ShowGroupInteractor {
    private final GroupRepository groupRepository;

    public ShowGroupInteractor(GroupRepository groupRepository) {
        this.groupRepository = groupRepository;
    }

    public Group get(int id) {
        return this.groupRepository.findById(id).get();
    }
}
