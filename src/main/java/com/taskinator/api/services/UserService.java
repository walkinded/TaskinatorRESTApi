package com.taskinator.api.services;

import com.taskinator.api.models.User;

import java.util.List;

public interface UserService {
    User getUser(Long id);
    List<User> getAll();
}
