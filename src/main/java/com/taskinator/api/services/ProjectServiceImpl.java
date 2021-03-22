package com.taskinator.api.services;

import com.taskinator.api.models.Project;
import com.taskinator.api.models.User;
import com.taskinator.api.repo.ProjectRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectServiceImpl implements ProjectService {

    private final ProjectRepo projectRepo;

    @Autowired
    public ProjectServiceImpl(ProjectRepo projectRepo) {
        this.projectRepo = projectRepo;
    }


    @Override
    public Project getProject(Long id) {
        return projectRepo.getById(id);
    }

    @Override
    public List<Project> getAll() {
        return (List<Project>) projectRepo.findAll();
    }
}
