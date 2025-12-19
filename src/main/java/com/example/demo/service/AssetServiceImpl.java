package com.example.demo.service;

import com.example.demo.entity.Asset;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.exception.ValidationException;
import com.example.demo.repository.AssetRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AssetServiceImpl implements AssetService {

    private final AssetRepository assetRepository;

    // Constructor Injection
    public AssetServiceImpl(AssetRepository assetRepository) {
        this.assetRepository = assetRepository;
    }

    @Override
    public Asset createAsset(Asset asset) {

        // VALIDATIONS
        if (asset.getAssetTag() == null || asset.getAssetTag().isBlank()) {
            throw new ValidationException("Asset tag is required");
        }

        if (assetRepository.findByAssetTag(asset.getAssetTag()).isPresent()) {
            throw new ValidationException("Asset tag already exists");
        }

        if (asset.getAssetType() == null || asset.getAssetType().isBlank()) {
            throw new ValidationException("Asset type is required");
        }

        return assetRepository.save(asset);
    }

    @Override
    public Asset getAsset(Long id) {
        return assetRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Asset not found with id: " + id));
    }

    @Override
    public List<Asset> getAllAssets() {
        return assetRepository.findAll();
    }

    @Override
    public Asset updateStatus(Long assetId, String status) {

        if (status == null || status.isBlank()) {
            throw new ValidationException("Status is required");
        }

        Asset asset = getAsset(assetId);
        asset.setStatus(status);
        return assetRepository.save(asset);
    }
}
