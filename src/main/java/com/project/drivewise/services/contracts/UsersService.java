package com.project.drivewise.services.contracts;

import com.project.drivewise.entities.Users;

import java.util.List;

public interface UsersService {

    List<Users> findAll();

    List<Users> findByUserId(Long id);

    Users save(Users user);

    void delete(Users user);

    void deleteById(Long id);
}
