package com.example.demo.service.impl;

import com.example.demo.entity.Asset;
import com.example.demo.entity.DisposalRecord;
import com.example.demo.entity.User;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.exception.ValidationException;
import com.example.demo.repository.AssetRepository;
import com.example.demo.repository.DisposalRecordRepository;
import com.example.demo.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class DisposalRecordServiceImpl implements DisposalRecordService {

    private final DisposalRecordRepository disposalRecordRepository;
    private final AssetRepository assetRepository;
    private final UserRepository userRepository;

    // REQUIRED constructor order
    public DisposalRecordServiceImpl(
            DisposalRecordRepository disposalRecordRepository,
            AssetRepository assetRepository,
            UserRepository userRepository) {

        this.disposalRecordRepository = disposalRecordRepository;
        this.assetRepository = assetRepository;
        this.userRepository = userRepository;
    }

    @Override
    public DisposalRecord createDisposal(Long assetId, DisposalRecord disposal) {

        Asset asset = assetRepository.findById(assetId)
                .orElseThrow(() -> new ResourceNotFoundException("Asset not found"));

        if (disposal.getDisposalMethod() == null || disposal.getDisposalMethod().isBlank()) {
            throw new ValidationException("Disposal method is required");
        }

        if (disposal.getDisposalDate() == null) {
            throw new ValidationException("Disposal date is required");
        }

        if (disposal.getDisposalDate().isAfter(LocalDate.now())) {
            throw new ValidationException("Disposal date cannot be in the future");
        }

        User approver = userRepository.findById(disposal.getApprovedBy().getId())
                .orElseThrow(() -> new ResourceNotFoundException("Approver not found"));

        if (!"ADMIN".equalsIgnoreCase(approver.getRole())) {
            throw new ValidationException("Disposal must be approved by ADMIN");
        }

        disposal.setAsset(asset);
        disposal.setApprovedBy(approver);

        // Auto update asset status
        asset.setStatus("DISPOSED");
        assetRepository.save(asset);

        return disposalRecordRepository.save(disposal);
    }

    @Override
    public DisposalRecord getDisposal(Long id) {
        return disposalRecordRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Disposal record not found"));
    }

    @Override
    public List<DisposalRecord> getAllDisposals() {
        return disposalRecordRepository.findAll();
    }
}
