package com.example.demo.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.User;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.exception.ValidationException;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    // ✅ Constructor Injection
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // 🔹 Register User
    @Override
    public User register(User user) {

        if (userRepository.findByEmail(user.getEmail()).isPresent()) {
            throw new ValidationException("Email already in use");
        }

        if (user.getPassword() == null || user.getPassword().length() < 8) {
            throw new ValidationException("Password must be at least 8 characters");
        }

        if (user.getDepartment() == null || user.getDepartment().isBlank()) {
            throw new ValidationException("Department is required");
        }

        return userRepository.save(user);
    }

    // 🔹 Find by Email
    @Override
    public User findByEmail(String email) {
        return userRepository.findByEmail(email)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));
    }

    // 🔹 Get All Users
    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    // 🔹 Get User by ID
    @Override
    public User getUserById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));
    }

    // 🔹 Update Department
    @Override
    public User updateDepartment(Long id, String department) {
        User user = getUserById(id);

        if (department == null || department.isBlank()) {
            throw new ValidationException("Department cannot be empty");
        }

        user.setDepartment(department);
        return userRepository.save(user);
    }

    // 🔹 Delete User
    @Override
    public void deleteUser(Long id) {
        User user = getUserById(id);
        userRepository.delete(user);
    }
}
