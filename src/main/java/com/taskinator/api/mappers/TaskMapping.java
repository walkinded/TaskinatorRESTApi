package com.taskinator.api.mappers;

import com.taskinator.api.dto.TaskDTO;
import com.taskinator.api.models.Task;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface TaskMapping {

    TaskMapping INSTANCE = Mappers.getMapper(TaskMapping.class);

    @Mapping(source = "user", target = "userDTO")
    TaskDTO toDTO(Task task);
}
