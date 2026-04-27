package com.project.drivewise.services.contracts;

import com.project.drivewise.entities.User;

import java.util.List;

public interface UserService {

    List<User> findAll();

    User save(User user);

    void delete(User user);
}
