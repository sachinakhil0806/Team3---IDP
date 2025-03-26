package com.project.InsuranceManagementSystem.entity;

public class Claim {
	  private int claimId;
	    private String claimType;
	    private double claimAmount;
	    private String claimStatus;
	    private String Status;
	    private User user;
	    private Policy policy;


	    // Getter and Setter for claimId
	    public int getClaimId() {
	        return claimId;
	    }

	    public void setClaimId(int claimId) {
	        this.claimId = claimId;
	    }

	    // Getter and Setter for claimType
	    public String getClaimType() {
	        return claimType;
	    }

	    public void setClaimType(String claimType) {
	        this.claimType = claimType;
	    }

	    // Getter and Setter for claimAmount
	    public double getClaimAmount() {
	        return claimAmount;
	    }

	    public void setClaimAmount(double claimAmount) {
	        this.claimAmount = claimAmount;
	    }

	    // Getter and Setter for claimStatus
	    public String getClaimStatus() {
	        return claimStatus;
	    }

	    public void setClaimStatus(String claimStatus) {
	        this.claimStatus = claimStatus;
	    }


	    public String getStatus() {
	        return Status;
	    }

	    public void setStatus(String status) {
	        Status = status;
	    }
}
