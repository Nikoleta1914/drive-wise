package com.project.drivewise.services;

import com.project.drivewise.entities.Users;
import com.project.drivewise.repositories.UsersRepository;
import com.project.drivewise.services.contracts.UsersService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsersServiceImpl implements UsersService {

    private UsersRepository userRepository;

    @Override
    public List<Users> findAll() {
        return userRepository.findAll();
    }

    @Override
    public List<Users> findByUserId(Long id) {
        return userRepository.findByUserId(id);
    }

    @Override
    public Users save(Users user) {
        return userRepository.save(user);
    }

    @Override
    public void delete(Users user) {
        userRepository.delete(user);
    }

    @Override
    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }
}
