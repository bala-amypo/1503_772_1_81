package com.example.demo.service;

import com.example.demo.entity.User;
import java.util.List;

public interface UserService {

    User register(User user);

    User findByEmail(String email);

    List<User> getAllUsers();

    User getUserById(Long id);

    User updateDepartment(Long id, String department);

    void deleteUser(Long id);
}
