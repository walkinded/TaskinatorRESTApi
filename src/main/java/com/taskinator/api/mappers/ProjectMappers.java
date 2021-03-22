package com.taskinator.api.mappers;

import com.taskinator.api.dto.ProjectDTO;
import com.taskinator.api.models.Project;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface ProjectMappers {

    ProjectMappers INSTANCE = Mappers.getMapper(ProjectMappers.class);

    @Mapping(source = "user", target = "userDTO")
    @Mapping(source = "task", target = "taskDTO")
    ProjectDTO toDTO(Project project);

    Iterable<ProjectDTO> toAll(List<Project> projects);
}
