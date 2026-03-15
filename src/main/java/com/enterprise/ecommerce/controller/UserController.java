package com.enterprise.ecommerce.controller;


import com.enterprise.ecommerce.entity.User;
import com.enterprise.ecommerce.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }

    @PostMapping
    public User createUser(@RequestBody User user){
        return userService.createUser(user);
    }

    @GetMapping
    public List<User> getUsers(){
        return userService.getAllUsers();
    }
}