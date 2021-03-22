package com.taskinator.api.services;

import com.taskinator.api.models.Project;
import com.taskinator.api.models.Task;

import java.util.List;

public interface TaskService {

    Task getTask(Long id);

    List<Task> getAll();
}
