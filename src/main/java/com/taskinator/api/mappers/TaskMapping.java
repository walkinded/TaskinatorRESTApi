package com.taskinator.api.mappers;

import com.taskinator.api.dto.TaskDTO;
import com.taskinator.api.dto.UserDTO;
import com.taskinator.api.models.Task;
import com.taskinator.api.models.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface TaskMapping {

    TaskMapping INSTANCE = Mappers.getMapper(TaskMapping.class);

    @Mapping(source = "user", target = "userDTO")
    TaskDTO toDTO(Task task);

    Iterable<TaskDTO> toAll(List<Task> tasks);
}
