package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class LifecycleEvent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Asset asset;

    private String eventType;
    private String description;
    private LocalDateTime eventTime;

    @ManyToOne
    private User user;

    public LifecycleEvent() {}

    public LifecycleEvent(Long id, Asset asset, String eventType,
                          String description, LocalDateTime eventTime, User user) {
        this.id = id;
        this.asset = asset;
        this.eventType = eventType;
        this.description = description;
        this.eventTime = eventTime;
        this.user = user;
    }

    // 🔥 REQUIRED BY SERVICE & TEST
    public String getEventDescription() {
        return description;
    }

    public Asset getAsset() { return asset; }
}
