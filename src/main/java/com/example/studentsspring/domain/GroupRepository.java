package com.example.studentsspring.domain;

import java.awt.print.Pageable;
import java.util.List;

public interface GroupRepository {
    void save(Group group);

    void remove(Group group);

    List<Group> findAllPaginated(Pageable pageable);
}
