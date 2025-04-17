package com.project.InsuranceManagementSystem.Controller;

import com.project.InsuranceManagementSystem.entity.Policy;
import com.project.InsuranceManagementSystem.Service.PolicyService;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Date;





@RestController
@RequestMapping("/admin/policies")
public class PolicyController {

    private final PolicyService policyService;

    public PolicyController(PolicyService policyService) {
        this.policyService = policyService;
    }

    // Get all policies
    @GetMapping
    public List<Policy> getAllPolicies() {
        return policyService.getAllPolicies();
    }

    // Get a policy by ID
    @GetMapping("/{id}")
    public ResponseEntity<Policy> getPolicyById(@PathVariable Long id) {
        Policy policy = policyService.getPolicyById(id);
        if (policy != null) {
            return ResponseEntity.ok(policy);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Add a new policy
    @PostMapping("/add")
    public ResponseEntity<Policy> createPolicy(@RequestParam String policyName,
            @RequestParam String policyDetails,
            @RequestParam Double premiumAmount,
            @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date validityPeriod) {
        Policy policy = new Policy();
        policy.setPolicyName(policyName);
        policy.setCoverageDetails(policyDetails);
        policy.setPremiumAmount(premiumAmount);
        policy.setValidityPeriod(validityPeriod);
        Policy createdPolicy = policyService.savePolicy(policy);
        return ResponseEntity.ok(createdPolicy);
    }

    // Remove a policy
    @PostMapping("/remove")
    public ResponseEntity<Void> removePolicy(@RequestParam Long policyId) {
        policyService.deletePolicy(policyId);
        return ResponseEntity.noContent().build();
    }

    // Assign a policy to an agent
    @PostMapping("/assign")
    public ResponseEntity<String> assignPolicyToAgent(@RequestParam Long policyId, @RequestParam Long agentId) {
        // Add logic to assign the policy to the agent
        return ResponseEntity.ok("Policy assigned successfully");
    }

    // Approve or reject a policy
    @PostMapping("/approve-reject")
    public ResponseEntity<String> approveOrRejectPolicy(@RequestParam Long policyId, @RequestParam String action) {
        if ("approve".equalsIgnoreCase(action)) {
            // Add logic to approve the policy
            return ResponseEntity.ok("Policy approved successfully");
        } else if ("reject".equalsIgnoreCase(action)) {
            // Add logic to reject the policy
            return ResponseEntity.ok("Policy rejected successfully");
        } else {
            return ResponseEntity.badRequest().body("Invalid action");
        }
    }

    // Update a policy
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

    // Delete a policy
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePolicy(@PathVariable Long id) {
        policyService.deletePolicy(id);
        return ResponseEntity.noContent().build();
    }
}
