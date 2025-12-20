package com.example.demo.controller;

import com.example.demo.entity.DisposalRecord;
import com.example.demo.service.DisposalRecordService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/disposals")
public class DisposalRecordController {

    private final DisposalRecordService disposalRecordService;

    public DisposalRecordController(DisposalRecordService disposalRecordService) {
        this.disposalRecordService = disposalRecordService;
    }

    // POST /api/disposals?assetId=1
    @PostMapping
    public DisposalRecord createDisposal(
            @RequestParam Long assetId,
            @RequestBody DisposalRecord disposal) {

        return disposalRecordService.createDisposal(assetId, disposal);
    }

    // GET /api/disposals/5
    @GetMapping("/{id}")
    public DisposalRecord getDisposal(@PathVariable Long id) {
        return disposalRecordService.getDisposal(id);
    }

    // GET /api/disposals
    @GetMapping
    public List<DisposalRecord> getAllDisposals() {
        return disposalRecordService.getAllDisposals();
    }
}
