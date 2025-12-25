package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;
    private String password;
    private String department;
    private String role;

    // REQUIRED
    public User() {}

    // REQUIRED BY TEST
    public User(String name, String email, String password, String department, String role) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.department = department;
        this.role = role;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public String getEmail() { return email; }
    public String getPassword() { return password; }
    public String getDepartment() { return department; }
    public String getRole() { return role; }
    public void setRole(String role) {
    this.role = role;
}

public void setPassword(String password) {
    this.password = password;
}

}
