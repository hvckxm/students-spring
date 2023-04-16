package com.students.infrastructure.repositories.group;

import com.students.domain.Group;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface GroupRepository extends PagingAndSortingRepository<Group, Integer>, CrudRepository<Group, Integer> {
}
