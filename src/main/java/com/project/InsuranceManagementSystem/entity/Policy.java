package com.project.InsuranceManagementSystem.entity;

public class Policy {
	private int policyId;
	private String policyName;
	private double policyAmount;   //premiumAmount
	private String coverageDetails;
	private String validityPeriod;
	private User user;
    private String role; // Values can be "customer", "Admin", or "Agent"

 
	public int getPolicyId() {
	    return policyId;
	}

	public void setPolicyId(int policyId) {
	    this.policyId = policyId;
	}

	public String getPolicyName() {
	    return policyName;
	}

	public void setPolicyName(String policyName) {
	    this.policyName = policyName;
	}

	public double getPolicyAmount() {
	    return policyAmount;
	}

	public void setPolicyAmount(double policyAmount) {
	    this.policyAmount = policyAmount;
	}

	public String getCoverageDetails() {
	    return coverageDetails;
	}

	public void setCoverageDetails(String coverageDetails) {
	    this.coverageDetails = coverageDetails;
	}

	public String getValidityPeriod() {
	    return validityPeriod;
	}

	public void setValidityPeriod(String validityPeriod) {
	    this.validityPeriod = validityPeriod;
	}
}
