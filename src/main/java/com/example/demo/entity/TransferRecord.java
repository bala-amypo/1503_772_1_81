package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class TransferRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Asset asset;

    private String fromDepartment;
    private String toDepartment;
    private LocalDate transferDate;

    @ManyToOne
    private User transferredBy;

    public TransferRecord() {}

    public TransferRecord(Long id, Asset asset, String fromDepartment,
                          String toDepartment, LocalDate transferDate, User transferredBy) {
        this.id = id;
        this.asset = asset;
        this.fromDepartment = fromDepartment;
        this.toDepartment = toDepartment;
        this.transferDate = transferDate;
        this.transferredBy = transferredBy;
    }

    public Asset getAsset() { return asset; }
}
