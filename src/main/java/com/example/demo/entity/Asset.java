package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
public class Asset {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String assetTag;
    private String name;
    private String category;
    private LocalDate purchaseDate;
    private String status;

    @ManyToOne
    private User assignedTo;

    private LocalDateTime createdAt;

    public Asset() {}

    // 🔥 TEST EXPECTS THIS CONSTRUCTOR
    public Asset(Long id, String assetTag, String name, String category,
                 LocalDate purchaseDate, String status, User assignedTo,
                 LocalDateTime createdAt) {
        this.id = id;
        this.assetTag = assetTag;
        this.name = name;
        this.category = category;
        this.purchaseDate = purchaseDate;
        this.status = status;
        this.assignedTo = assignedTo;
        this.createdAt = createdAt;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getStatus() { return status; }
    public void setStatus(String status) {
    this.status = status;
}

}
