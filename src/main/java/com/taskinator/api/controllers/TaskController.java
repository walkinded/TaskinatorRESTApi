package com.taskinator.api.controllers;

import com.taskinator.api.dto.TaskDTO;
import com.taskinator.api.mappers.TaskMapping;
import com.taskinator.api.models.Task;
import com.taskinator.api.repo.TaskRepo;
import com.taskinator.api.services.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/task/")
public class TaskController {

    private final TaskService taskService;
    private final TaskRepo taskRepo;

    @RequestMapping(value = {"{id}"}, method = RequestMethod.GET)
    public TaskDTO getTaskById(@PathVariable Long id) {
        Task task = taskService.getTask(id);
        return TaskMapping.INSTANCE.toDTO(task);
    }

    @RequestMapping(value = {"all"}, method = RequestMethod.GET)
    public List<TaskDTO> getAll() {
        List<Task> tasks = taskService.getAll();
        return (List<TaskDTO>) TaskMapping.INSTANCE.toAll(tasks);
    }

    @RequestMapping(value = {"{id}/remove"}, method = RequestMethod.DELETE)
    public void delete(@PathVariable("id") Task task){
        taskRepo.delete(task);
    }

    @RequestMapping(value = {"edit/{id}"}, method = RequestMethod.PUT)
    public Task update(
            @PathVariable("id") Task taskFromDb,
            @RequestBody Task task
    ) {
        BeanUtils.copyProperties(task, taskFromDb, "id");
        return taskRepo.save(taskFromDb);
    }

    @RequestMapping(value = {"new"}, method = RequestMethod.POST)
    public Task create(@RequestBody Task task) {
        return taskRepo.save(task);
    }
}