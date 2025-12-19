package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private final UserService service;
    public UserController(UserService service) { this.service = service; }

    @PostMapping("/register")
    public User createUser(@RequestBody User user) { return service.createUser(user); }

    @GetMapping
    public List<User> getAllUsers() { return service.getAllUsers(); }

    @GetMapping("/{id}")
    public User getUser(@PathVariable Long id) { return service.getUser(id); }
}
