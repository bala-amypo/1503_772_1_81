package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "assets")
public class Asset {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String assetName;

    @Column(nullable = false, unique = true)
    private String assetTag;

    @Column(nullable = false)
    private String category;

    @Column(nullable = false)
    private String status;

    @Column(nullable = false)
    private LocalDate purchaseDate;

    private String description;

    @ManyToOne
    @JoinColumn(name = "assigned_to")
    private User assignedTo;

    private LocalDateTime createdAt;

    // ✅ REQUIRED: No-args constructor (JPA + Tests)
    public Asset() {
    }

    // ✅ REQUIRED: Constructor used heavily in TESTS
    public Asset(
            Long id,
            String assetName,
            String assetTag,
            String category,
            String status,
            LocalDate purchaseDate,
            String description,
            User assignedTo,
            LocalDateTime createdAt
    ) {
        this.id = id;
        this.assetName = assetName;
        this.assetTag = assetTag;
        this.category = category;
        this.status = status;
        this.purchaseDate = purchaseDate;
        this.description = description;
        this.assignedTo = assignedTo;
        this.createdAt = createdAt != null ? createdAt : LocalDateTime.now();
    }

    // ✅ REQUIRED: Constructor WITHOUT id (used in tests)
    public Asset(
            String assetName,
            String assetTag,
            String category,
            String status,
            LocalDate purchaseDate,
            String description,
            User assignedTo,
            LocalDateTime createdAt
    ) {
        this.assetName = assetName;
        this.assetTag = assetTag;
        this.category = category;
        this.status = status;
        this.purchaseDate = purchaseDate;
        this.description = description;
        this.assignedTo = assignedTo;
        this.createdAt = createdAt != null ? createdAt : LocalDateTime.now();
    }

    // ================= GETTERS & SETTERS =================

    public Long getId() {
        return id;
    }

    // 🔥 REQUIRED BY TESTS
    public void setId(Long id) {
        this.id = id;
    }

    public String getAssetName() {
        return assetName;
    }

    public void setAssetName(String assetName) {
        this.assetName = assetName;
    }

    public String getAssetTag() {
        return assetTag;
    }

    public void setAssetTag(String assetTag) {
        this.assetTag = assetTag;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    // 🔥 REQUIRED: Tests call setStatus(String)
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDate getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(LocalDate purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public User getAssignedTo() {
        return assignedTo;
    }

    public void setAssignedTo(User assignedTo) {
        this.assignedTo = assignedTo;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
}
