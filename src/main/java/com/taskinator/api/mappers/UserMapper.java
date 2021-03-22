package com.taskinator.api.mappers;

import com.taskinator.api.dto.UserDTO;
import com.taskinator.api.models.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    UserDTO toDTO(User user);

    Iterable<UserDTO> toAll(List<User> users);
}
