package com.project.InsuranceManagementSystem.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "users") // Optional: specify the table name if different from the class name
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
        if (!role.equalsIgnoreCase("customer") && !role.equalsIgnoreCase("agent") && !role.equalsIgnoreCase("admin")) {
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

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", phone='" + phone + '\'' +
                ", role='" + role + '\'' +
                '}';
    }

    // public String getAddress() {
    //     return address;
    // }

    // public void setAddress(String email) {
    //     this.address = address;
    // }
}
