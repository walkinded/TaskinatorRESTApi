package com.taskinator.api.services;

import com.taskinator.api.models.User;
import com.taskinator.api.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepo userRepo;

    @Autowired
    public UserServiceImpl(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public User getUser(Long id) {
        return userRepo.getById(id);
    }

    @Override
    public List<User> getAll() {
        return (List<User>) userRepo.findAll();
    }
}
