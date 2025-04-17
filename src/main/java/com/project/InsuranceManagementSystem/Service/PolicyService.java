package com.project.InsuranceManagementSystem.Service;

import com.project.InsuranceManagementSystem.entity.Policy;
import com.project.InsuranceManagementSystem.Repository.PolicyRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PolicyService {

    private final PolicyRepository policyRepository;

    public PolicyService(PolicyRepository policyRepository) {
        this.policyRepository = policyRepository;
    }

    public List<Policy> getAllPolicies() {
        return policyRepository.findAll();
    }

    public Policy getPolicyById(Long policyId) {
        return policyRepository.findById(policyId).orElse(null);
    }

    public Policy savePolicy(Policy policy) {
        return policyRepository.save(policy);
    }

    public void deletePolicy(Long policyId) {
        policyRepository.deleteById(policyId);
    }
}