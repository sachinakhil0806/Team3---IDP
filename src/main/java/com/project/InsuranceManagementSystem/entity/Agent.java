package com.project.InsuranceManagementSystem.entity;

public class Agent {
	 private int id;
	    private String name;
	    private String email;
	    private String phone;
	    private int assignedPolicies;
	    private Policy policy;

	    // Getter and Setter for id
	    public int getId() {
	        return id;
	    }

	    public void setId(int id) {
	        this.id = id;
	    }

	    // Getter and Setter for name
	    public String getName() {
	        return name;
	    }

	    public void setName(String name) {
	        this.name = name;
	    }

	    // Getter and Setter for email
	    public String getEmail() {
	        return email;
	    }

	    public void setEmail(String email) {
	        this.email = email;
	    }

	    // Getter and Setter for phone
	    public String getPhone() {
	        return phone;
	    }

	    public void setPhone(String phone) {
	        this.phone = phone;
	    }

	    public int getAssignedPolicies() {
	        return assignedPolicies;
	    }

	    public void setAssignedPolicies(int assignedPolicies) {
	        this.assignedPolicies = assignedPolicies;
	    }
}
