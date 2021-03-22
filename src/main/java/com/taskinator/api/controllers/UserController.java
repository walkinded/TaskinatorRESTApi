package com.taskinator.api.controllers;

import com.taskinator.api.dto.UserDTO;
import com.taskinator.api.mappers.UserMapper;
import com.taskinator.api.models.User;
import com.taskinator.api.repo.UserRepo;
import com.taskinator.api.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/user/")
public class UserController {
    @Autowired
    private final UserService userService;

    private final UserRepo userRepo;


    @RequestMapping(value = {"{id}"}, method = RequestMethod.GET)
    public UserDTO getUserById(@PathVariable Long id) {
        User user = userService.getUser(id);
        return UserMapper.INSTANCE.toDTO(user);
    }

    @RequestMapping(value = {"all"}, method = RequestMethod.GET)
    public List<UserDTO> getAll() {
        List<User> user = userService.getAll();
        return (List<UserDTO>) UserMapper.INSTANCE.toAll(user);
    }

    @RequestMapping(value = {"{id}/remove"}, method = RequestMethod.DELETE)
    public void delete(@PathVariable("id") User user){
        userRepo.delete(user);
    }

    @RequestMapping(value = {"edit/{id}"}, method = RequestMethod.PUT)
    public User update(
            @PathVariable("id") User userFromDb,
            @RequestBody User user
    ) {
        BeanUtils.copyProperties(user, userFromDb, "id");
        return userRepo.save(userFromDb);
    }

    @RequestMapping(value = {"new"}, method = RequestMethod.POST)
    public User create(@RequestBody User user) {
        return userRepo.save(user);
    }
}
