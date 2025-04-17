package com.project.InsuranceManagementSystem.Service;

import com.project.InsuranceManagementSystem.entity.Claim;
import com.project.InsuranceManagementSystem.Repository.ClaimRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClaimService {
    private final ClaimRepository claimRepository;

    public ClaimService(ClaimRepository claimRepository) {
        this.claimRepository = claimRepository;
    }

    public List<Claim> getAllClaims() {
        return claimRepository.findAll();
    }

    public Claim saveClaim(Claim claim) {
        return claimRepository.save(claim);
    }

    public void deleteClaim(Long claimId) {
        claimRepository.deleteById(claimId);
    }
}