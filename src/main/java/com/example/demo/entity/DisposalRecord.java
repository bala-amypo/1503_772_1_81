package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "disposal_records")
public class DisposalRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "asset_id", nullable = false)
    private Asset asset;

    @Column(nullable = false)
    private String reason;

    @Column(nullable = false)
    private LocalDate disposalDate;

    @ManyToOne
    @JoinColumn(name = "approved_by")
    private User approvedBy;

    private LocalDateTime createdAt;

    // ✅ REQUIRED: No-args constructor
    public DisposalRecord() {
    }

    // ✅ REQUIRED: Constructor used in TESTS
    public DisposalRecord(
            Long id,
            Asset asset,
            String reason,
            LocalDate disposalDate,
            User approvedBy,
            String remarks,
            LocalDateTime createdAt
    ) {
        this.id = id;
        this.asset = asset;
        this.reason = reason;
        this.disposalDate = disposalDate;
        this.approvedBy = approvedBy;
        this.createdAt = createdAt != null ? createdAt : LocalDateTime.now();
    }

    // ✅ OPTIONAL constructor
    public DisposalRecord(
            Asset asset,
            String reason,
            LocalDate disposalDate,
            User approvedBy
    ) {
        this.asset = asset;
        this.reason = reason;
        this.disposalDate = disposalDate;
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

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public LocalDate getDisposalDate() {
        return disposalDate;
    }

    public void setDisposalDate(LocalDate disposalDate) {
        this.disposalDate = disposalDate;
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
