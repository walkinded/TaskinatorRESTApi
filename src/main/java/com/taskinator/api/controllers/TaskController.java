package com.taskinator.api.controllers;

import com.taskinator.api.dto.TaskDTO;
import com.taskinator.api.mappers.TaskMapping;
import com.taskinator.api.models.Task;
import com.taskinator.api.services.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/task/")
public class TaskController {

    private final TaskService taskService;

    @RequestMapping(value = {"{id}"}, method = RequestMethod.GET)
    public TaskDTO getTaskById(@PathVariable Long id) {
        Task task = taskService.getTask(id);
        return TaskMapping.INSTANCE.toDTO(task);
    }
}
