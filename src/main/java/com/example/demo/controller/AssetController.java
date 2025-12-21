package com.example.demo.controller;
import jakarta.validation.Valid;
import com.example.demo.entity.Asset;
import com.example.demo.service.AssetService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/assets")
public class AssetController {

    private final AssetService assetService;

    // Constructor Injection
    public AssetController(AssetService assetService) {
        this.assetService = assetService;
    }

    // CREATE ASSET
    @PostMapping
    public Asset createAsset(@Valid @RequestBody Asset asset) {
        return assetService.createAsset(asset);
    }

    // GET ALL ASSETS
    @GetMapping
    public List<Asset> getAllAssets() {
        return assetService.getAllAssets();
    }

    // GET ASSET BY ID
    @GetMapping("/{id}")
    public Asset getAsset(@PathVariable Long id) {
        return assetService.getAsset(id);
    }

    // UPDATE STATUS
    @PutMapping("/status/{id}")
    public Asset updateStatus(
            @PathVariable Long id,
            @RequestBody Asset asset) {
        return assetService.updateStatus(id, asset.getStatus());
    }
}
