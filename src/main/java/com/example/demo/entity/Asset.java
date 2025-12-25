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

    @Column(nullable = false)
    private String assetType;

    @Column(nullable = false, unique = true)
    private String serialNumber;

    @Column(nullable = false)
    private LocalDate purchaseDate;

    @Column(nullable = false)
    private String status;

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
            String assetType,
            String serialNumber,
            LocalDate purchaseDate,
            String status,
            User assignedTo,
            LocalDateTime createdAt
    ) {
        this.id = id;
        this.assetName = assetName;
        this.assetType = assetType;
        this.serialNumber = serialNumber;
        this.purchaseDate = purchaseDate;
        this.status = status;
        this.assignedTo = assignedTo;
        this.createdAt = createdAt;
    }

    // ✅ OPTIONAL: Convenience constructor
    public Asset(
            String assetName,
            String assetType,
            String serialNumber,
            LocalDate purchaseDate,
            String status,
            User assignedTo
    ) {
        this.assetName = assetName;
        this.assetType = assetType;
        this.serialNumber = serialNumber;
        this.purchaseDate = purchaseDate;
        this.status = status;
        this.assignedTo = assignedTo;
        this.createdAt = LocalDateTime.now();
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

    public String getAssetType() {
        return assetType;
    }

    public void setAssetType(String assetType) {
        this.assetType = assetType;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public LocalDate getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(LocalDate purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public String getStatus() {
        return status;
    }

    // 🔥 REQUIRED: findByStatus() test usage
    public void setStatus(String status) {
        this.status = status;
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
