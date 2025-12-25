package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "lifecycle_events")
public class LifecycleEvent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "asset_id", nullable = false)
    private Asset asset;

    @Column(nullable = false)
    private String eventType;

    @Column(nullable = false)
    private String description;

    private LocalDateTime eventTime;

    @ManyToOne
    @JoinColumn(name = "performed_by")
    private User performedBy;

    // ✅ REQUIRED: No-args constructor
    public LifecycleEvent() {
    }

    // ✅ REQUIRED: Constructor used in TESTS
    public LifecycleEvent(
            Long id,
            Asset asset,
            String eventType,
            String description,
            LocalDateTime eventTime,
            User performedBy
    ) {
        this.id = id;
        this.asset = asset;
        this.eventType = eventType;
        this.description = description;
        this.eventTime = eventTime != null ? eventTime : LocalDateTime.now();
        this.performedBy = performedBy;
    }

    // ✅ OPTIONAL constructor
    public LifecycleEvent(
            Asset asset,
            String eventType,
            String description,
            User performedBy
    ) {
        this.asset = asset;
        this.eventType = eventType;
        this.description = description;
        this.eventTime = LocalDateTime.now();
        this.performedBy = performedBy;
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

    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getEventTime() {
        return eventTime;
    }

    public User getPerformedBy() {
        return performedBy;
    }

    public void setPerformedBy(User performedBy) {
        this.performedBy = performedBy;
    }
    public String getEventDescription() {
    return this.description;
}

public void setEventDescription(String eventDescription) {
    this.description = eventDescription;
}
}
