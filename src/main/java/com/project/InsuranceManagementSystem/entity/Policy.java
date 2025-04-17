package com.project.InsuranceManagementSystem.entity;

import jakarta.persistence.*;

@Entity
public class Policy {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "policy_seq_gen")
    @SequenceGenerator(name = "policy_seq_gen", sequenceName = "policy_seq", allocationSize = 1)
    private Long policyId;

    private String policyName;
    private String coverageDetails;
    private Double premiumAmount;
    private java.util.Date validityPeriod;

    // Getters and Setters
    public Long getPolicyId() {
        return policyId;
    }

    public void setPolicyId(Long policyId) {
        this.policyId = policyId;
    }

    public String getPolicyName() {
        return policyName;
    }

    public void setPolicyName(String policyName) {
        this.policyName = policyName;
    }

    public String getCoverageDetails() {
        return coverageDetails;
    }

    public void setCoverageDetails(String coverageDetails) {
        this.coverageDetails = coverageDetails;
    }

    public Double getPremiumAmount() {
        return premiumAmount;
    }

    public void setPremiumAmount(Double premiumAmount) {
        this.premiumAmount = premiumAmount;
    }

    public java.util.Date getValidityPeriod() {
        return validityPeriod;
    }

    public void setValidityPeriod(java.util.Date validityPeriod) {
        this.validityPeriod = validityPeriod;
    }
}