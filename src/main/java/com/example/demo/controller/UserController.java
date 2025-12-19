package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    // ✅ Constructor Injection (MANDATORY)
    public UserController(UserService userService) {
        this.userService = userService;
    }

    // 🔹 Get all users (ADMIN)
    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    // 🔹 Get user by ID (ADMIN)
    @GetMapping("/{id}")
    public User getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    // 🔹 Get user by email (ADMIN / INTERNAL)
    @GetMapping("/email/{email}")
    public User getUserByEmail(@PathVariable String email) {
        return userService.findByEmail(email);
    }

    // 🔹 Update user department (ADMIN)
    @PutMapping("/{id}/department")
    public User updateDepartment(@PathVariable Long id,
                                 @RequestParam String department) {
        return userService.updateDepartment(id, department);
    }

    // 🔹 Delete user (ADMIN)
    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return "User deleted successfully";
    }
}
