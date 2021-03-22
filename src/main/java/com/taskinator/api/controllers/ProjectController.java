package com.taskinator.api.controllers;

import com.taskinator.api.dto.ProjectDTO;
import com.taskinator.api.mappers.ProjectMappers;
import com.taskinator.api.models.Project;
import com.taskinator.api.repo.ProjectRepo;
import com.taskinator.api.services.ProjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/project/")
public class ProjectController {

    private final ProjectService projectService;
    private final ProjectRepo projectRepo;

    @RequestMapping(value = {"{id}"}, method = RequestMethod.GET)
    public ProjectDTO getProjectById(@PathVariable Long id) {
        Project project = projectService.getProject(id);
        return ProjectMappers.INSTANCE.toDTO(project);
    }

    @RequestMapping(value = {"all"}, method = RequestMethod.GET)
    public List<ProjectDTO> getAll() {
        List<Project> projects = projectService.getAll();
        return (List<ProjectDTO>) ProjectMappers.INSTANCE.toAll(projects);
    }

    @RequestMapping(value = {"{id}/remove"}, method = RequestMethod.DELETE)

    public void deleteProject(@PathVariable("id") Project project){
        projectRepo.delete(project);
    }

    @RequestMapping(value = {"edit/{id}"}, method = RequestMethod.PUT)
    public Project updateProject(
            @PathVariable("id") Project projectFromDb,
            @RequestBody Project project
    ) {
        BeanUtils.copyProperties(project, projectFromDb, "id");
        return projectRepo.save(projectFromDb);
    }

    @RequestMapping(value = {"new"}, method = RequestMethod.POST)
    public Project createProject(@RequestBody Project project) {
        return projectRepo.save(project);
    }
}
