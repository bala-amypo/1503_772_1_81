package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "transfer_records")
public class TransferRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "asset_id", nullable = false)
    private Asset asset;

    @Column(nullable = false)
    private String fromDepartment;

    @Column(nullable = false)
    private String toDepartment;

    @Column(nullable = false)
    private LocalDate transferDate;

    @ManyToOne
    @JoinColumn(name = "approved_by")
    private User approvedBy;

    private LocalDateTime createdAt;

    // ✅ REQUIRED: No-args constructor (JPA + Tests)
    public TransferRecord() {
    }

    // ✅ REQUIRED: Constructor used in TESTS
    public TransferRecord(
            Long id,
            Asset asset,
            String fromDepartment,
            String toDepartment,
            LocalDate transferDate,
            User approvedBy
    ) {
        this.id = id;
        this.asset = asset;
        this.fromDepartment = fromDepartment;
        this.toDepartment = toDepartment;
        this.transferDate = transferDate;
        this.approvedBy = approvedBy;
        this.createdAt = LocalDateTime.now();
    }

    // ✅ OPTIONAL: Convenience constructor
    public TransferRecord(
            Asset asset,
            String fromDepartment,
            String toDepartment,
            LocalDate transferDate,
            User approvedBy
    ) {
        this.asset = asset;
        this.fromDepartment = fromDepartment;
        this.toDepartment = toDepartment;
        this.transferDate = transferDate;
        this.approvedBy = approvedBy;
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

    public Asset getAsset() {
        return asset;
    }

    public void setAsset(Asset asset) {
        this.asset = asset;
    }

    public String getFromDepartment() {
        return fromDepartment;
    }

    public void setFromDepartment(String fromDepartment) {
        this.fromDepartment = fromDepartment;
    }

    public String getToDepartment() {
        return toDepartment;
    }

    public void setToDepartment(String toDepartment) {
        this.toDepartment = toDepartment;
    }

    public LocalDate getTransferDate() {
        return transferDate;
    }

    public void setTransferDate(LocalDate transferDate) {
        this.transferDate = transferDate;
    }

    public User getApprovedBy() {
        return approvedBy;
    }

    public void setApprovedBy(User approvedBy) {
        this.approvedBy = approvedBy;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
}
