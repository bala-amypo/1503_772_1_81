package com.example.demo.controller;

import com.example.demo.entity.Asset;
import com.example.demo.service.AssetService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/assets")
public class AssetController {

    private final AssetService assetService;

    // Constructor Injection (MANDATORY)
    public AssetController(AssetService assetService) {
        this.assetService = assetService;
    }

    // Create Asset
    @PostMapping
    public Asset createAsset(@RequestBody Asset asset) {
        return assetService.createAsset(asset);
    }

    // Get All Assets
    @GetMapping
    public List<Asset> getAllAssets() {
        return assetService.getAllAssets();
    }

    // Get Asset by ID
    @GetMapping("/{id}")
    public Asset getAssetById(@PathVariable Long id) {
        return assetService.getAsset(id);
    }

    // Update Asset Status
    @PutMapping("/status/{id}")
    public Asset updateAssetStatus(
            @PathVariable Long id,
            @RequestBody Asset asset) {
        return assetService.updateStatus(id, asset.getStatus());
    }
}
