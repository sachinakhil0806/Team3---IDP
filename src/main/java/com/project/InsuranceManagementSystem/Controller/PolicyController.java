package com.project.InsuranceManagementSystem.Controller;

import com.project.InsuranceManagementSystem.entity.Policy;
import com.project.InsuranceManagementSystem.Service.PolicyService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin/policies")
public class PolicyController {

    private final PolicyService policyService;

    public PolicyController(PolicyService policyService) {
        this.policyService = policyService;
    }

    @GetMapping
    public List<Policy> getAllPolicies() {
        return policyService.getAllPolicies();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Policy> getPolicyById(@PathVariable Long id) {
        Policy policy = policyService.getPolicyById(id);
        if (policy != null) {
            return ResponseEntity.ok(policy);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public Policy createPolicy(@RequestBody Policy policy) {
        return policyService.savePolicy(policy);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Policy> updatePolicy(@PathVariable Long id, @RequestBody Policy updatedPolicy) {
        Policy existingPolicy = policyService.getPolicyById(id);
        if (existingPolicy != null) {
            existingPolicy.setPolicyName(updatedPolicy.getPolicyName());
            existingPolicy.setCoverageDetails(updatedPolicy.getCoverageDetails());
            existingPolicy.setPremiumAmount(updatedPolicy.getPremiumAmount());
            existingPolicy.setValidityPeriod(updatedPolicy.getValidityPeriod());
            return ResponseEntity.ok(policyService.savePolicy(existingPolicy));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePolicy(@PathVariable Long id) {
        if (policyService.getPolicyById(id) != null) {
            policyService.deletePolicy(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}