package com.project.InsuranceManagementSystem.entity;

public class User {
	private int id;
    private String name;
    private String email;
    private String password;
    private String phone;
    // private String address;
    private String role;     // Values can be "customer", or "Agent"

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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        if (!role.equalsIgnoreCase("customer") && !role.equalsIgnoreCase("agent")) {
             throw new IllegalArgumentException("Invalid role. Allowed values: customer, agent.");
        }
        this.role = role.toLowerCase();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    // public String getAddress() {
    //     return address;
    // }

    // public void setAddress(String email) {
    //     this.address = address;
    // }
}
