package com.project.InsuranceManagementSystem.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.InsuranceManagementSystem.entity.Admin;

public interface AdminRepository extends JpaRepository<Admin, Long> {
}