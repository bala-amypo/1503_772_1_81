package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String fullName;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String department;

    @Column(nullable = false)
    private String role;

    @Column(nullable = false)
    private String password;

    private LocalDateTime createdAt;

    /* =========================
       Relationships
       ========================= */

    @OneToMany(mappedBy = "currentHolder")
    private List<Asset> assets;

    @OneToMany(mappedBy = "performedBy")
    private List<LifecycleEvent> lifecycleEvents;

    @OneToMany(mappedBy = "approvedBy")
    private List<TransferRecord> transferRecords;

    @OneToMany(mappedBy = "approvedBy")
    private List<DisposalRecord> disposalRecords;

    /* =========================
       Constructors
       ========================= */

    public User() {
    }

    public User(Long id,
                String fullName,
                String email,
                String department,
                String role,
                String password,
                LocalDateTime createdAt) {

        this.id = id;
        this.fullName = fullName;
        this.email = email;
        this.department = department;
        this.role = role;
        this.password = password;
        this.createdAt = createdAt;
    }

    /* =========================
       Lifecycle Hooks
       ========================= */

    @PrePersist
    protected void onCreate() {
        if (this.role == null) {
            this.role = "USER";
        }
        if (this.createdAt == null) {
            this.createdAt = LocalDateTime.now();
        }
    }

    /* =========================
       Getters & Setters
       ========================= */

    public Long getId() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
}
