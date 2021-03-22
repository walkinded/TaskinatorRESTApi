package com.taskinator.api.services;

import com.taskinator.api.models.Project;

import java.util.List;

public interface ProjectService {

    Project getProject(Long id);

    List<Project> getAll();
}
