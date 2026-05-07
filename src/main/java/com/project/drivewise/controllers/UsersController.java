package com.project.drivewise.controllers;


import com.project.drivewise.entities.Users;
import com.project.drivewise.services.contracts.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UsersController {

    private UsersService usersService;

    @Autowired
    public UsersController(UsersService usersService){
        this.usersService = usersService;
    }

    @GetMapping
    public List<Users> findAll(){
        return usersService.findAll();
    }

    @GetMapping("/{userId}")
    public List<Users> findById(@PathVariable Long id){
        return usersService.findByUserId(id);
    }

    @PostMapping
    public Users save(@RequestBody Users users){
        return usersService.save(users);
    }

    @DeleteMapping
    public String delete(@PathVariable Users users){
        usersService.delete(users);
        return "All users have been deleted.";
    }

    @DeleteMapping("/{id}")
    public String deleteById(@PathVariable Long id){
        usersService.deleteById(id);
        return "User with id " + id + " has been deleted.";
    }


}
