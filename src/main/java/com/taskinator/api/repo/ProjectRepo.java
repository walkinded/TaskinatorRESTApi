package com.taskinator.api.repo;

import com.taskinator.api.models.Project;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectRepo extends CrudRepository<Project, Long> {
    Project getById(Long id);
}
