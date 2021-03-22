package com.taskinator.api.repo;

import com.taskinator.api.models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface UserRepo extends CrudRepository<User, Long> {
    User getById(Long id);;
}
