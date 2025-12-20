package com.example.demo.controller;

import com.example.demo.entity.TransferRecord;
import com.example.demo.service.TransferRecordService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/transfers")
public class TransferRecordController {

    private final TransferRecordService transferRecordService;

    public TransferRecordController(TransferRecordService transferRecordService) {
        this.transferRecordService = transferRecordService;
    }

    // POST /api/transfers?assetId=1
    @PostMapping
    public TransferRecord createTransfer(
            @RequestParam Long assetId,
            @RequestBody TransferRecord record) {

        return transferRecordService.createTransfer(assetId, record);
    }

    // GET /api/transfers/asset/1
    @GetMapping("/asset/{assetId}")
    public List<TransferRecord> getTransfersForAsset(@PathVariable Long assetId) {
        return transferRecordService.getTransfersForAsset(assetId);
    }

    // GET /api/transfers/5
    @GetMapping("/{id}")
    public TransferRecord getTransfer(@PathVariable Long id) {
        return transferRecordService.getTransfer(id);
    }
}
