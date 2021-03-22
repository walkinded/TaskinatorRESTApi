package com.taskinator.api.services;

import com.taskinator.api.models.Task;
import com.taskinator.api.models.User;
import com.taskinator.api.repo.TaskRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {

    private final TaskRepo taskRepo;

    @Autowired
    public TaskServiceImpl(TaskRepo taskRepo) {
        this.taskRepo = taskRepo;
    }

    @Override
    public Task getTask(Long id) {
        return taskRepo.getById(id);
    }

    @Override
    public List<Task> getAll() {
        return (List<Task>) taskRepo.findAll();
    }
}
