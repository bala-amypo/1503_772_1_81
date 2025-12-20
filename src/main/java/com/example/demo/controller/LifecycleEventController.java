package com.example.demo.controller;

import com.example.demo.entity.LifecycleEvent;
import com.example.demo.service.LifecycleEventService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/events")
public class LifecycleEventController {

    private final LifecycleEventService lifecycleEventService;

    public LifecycleEventController(LifecycleEventService lifecycleEventService) {
        this.lifecycleEventService = lifecycleEventService;
    }

    // POST /api/events?assetId=1&userId=2
    @PostMapping
    public LifecycleEvent logEvent(
            @RequestParam Long assetId,
            @RequestParam Long userId,
            @RequestBody LifecycleEvent event) {

        return lifecycleEventService.logEvent(assetId, userId, event);
    }

    // GET /api/events/asset/1
    @GetMapping("/asset/{assetId}")
    public List<LifecycleEvent> getEventsByAsset(@PathVariable Long assetId) {
        return lifecycleEventService.getEventsForAsset(assetId);
    }

    // GET /api/events/5
    @GetMapping("/{id}")
    public LifecycleEvent getEvent(@PathVariable Long id) {
        return lifecycleEventService.getEvent(id);
    }
}
