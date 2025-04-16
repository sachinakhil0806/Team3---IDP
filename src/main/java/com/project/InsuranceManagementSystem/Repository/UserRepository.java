package com.project.InsuranceManagementSystem.Repository;

import com.project.InsuranceManagementSystem.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
    User findByEmail(String email); // Custom query method to find a user by email
}