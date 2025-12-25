package com.example.demo.dto;

public class RegisterRequest {

    private String name;
    private String email;
    private String password;
    private String department;

    public RegisterRequest() {}

    public RegisterRequest(String name, String email, String password, String department) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.department = department;
    }

    public String getEmail() { return email; }
    public String getPassword() { return password; }
    public String getDepartment() { return department; }
}
