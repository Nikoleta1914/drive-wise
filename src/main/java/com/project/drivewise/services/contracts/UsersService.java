package com.project.drivewise.services.contracts;

import com.project.drivewise.entities.Users;

import java.util.List;
import java.util.Optional;

public interface UsersService {

    List<Users> findAll();

    Optional<Users> findById(Long id);

    Users save(Users user);

    void delete(Users user);

    void deleteById(Long id);

}
