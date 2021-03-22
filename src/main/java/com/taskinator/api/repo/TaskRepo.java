package com.taskinator.api.repo;

import com.taskinator.api.models.Task;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepo extends CrudRepository<Task, Long> {
    Task getById(Long id);
}
