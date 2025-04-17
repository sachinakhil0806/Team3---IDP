package com.project.InsuranceManagementSystem.Repository;

import com.project.InsuranceManagementSystem.entity.Claim;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClaimRepository extends JpaRepository<Claim, Long> {
}