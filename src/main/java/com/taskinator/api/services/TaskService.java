package com.taskinator.api.services;

import com.taskinator.api.models.Task;

public interface TaskService {

    Task getTask(Long id);
}
