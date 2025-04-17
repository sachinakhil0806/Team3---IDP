package com.project.InsuranceManagementSystem.Repository;

import com.project.InsuranceManagementSystem.entity.Policy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
// This interface extends JpaRepository to provide CRUD operations for the Policy entity.
public interface PolicyRepository extends JpaRepository<Policy, Long> {
}