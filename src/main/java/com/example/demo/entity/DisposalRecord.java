package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
public class DisposalRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Asset asset;

    private String reason;
    private LocalDate disposalDate;

    @ManyToOne
    private User disposedBy;

    private LocalDateTime createdAt;

    public DisposalRecord() {}

    public DisposalRecord(Long id, Asset asset, String reason,
                          LocalDate disposalDate, User disposedBy,
                          LocalDateTime createdAt) {
        this.id = id;
        this.asset = asset;
        this.reason = reason;
        this.disposalDate = disposalDate;
        this.disposedBy = disposedBy;
        this.createdAt = createdAt;
    }
}
