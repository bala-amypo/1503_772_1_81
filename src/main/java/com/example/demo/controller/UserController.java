package com.example.demo.controller;
import jakarta.validation.Valid;
import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    // Constructor Injection (MANDATORY)
    public UserController(UserService userService) {
        this.userService = userService;
    }

    // Create/Register User
    @PostMapping
    public User createUser(@Valid @RequestBody User user) {
        return userService.registerUser(user);
    }

    // Get All Users
    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    // Get User by ID
    @GetMapping("/{id}")
    public User getUserById(@PathVariable Long id) {
        return userService.getUser(id);
    }
}
