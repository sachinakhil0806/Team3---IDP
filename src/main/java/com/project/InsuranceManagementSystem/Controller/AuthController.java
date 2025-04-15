package com.project.InsuranceManagementSystem.Controller;

import com.project.InsuranceManagementSystem.entity.User;
import com.project.InsuranceManagementSystem.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/register")
    public String showRegisterPage() {
        return "auth/register"; // Return the register.html page
    }

    @PostMapping("/register")
    public String registerUser(@RequestParam String name, @RequestParam String email,
                               @RequestParam String password, @RequestParam String role, Model model) {

        System.out.println("RegeisterUser Method called");
        if (userRepository.findByEmail(email) != null) {
            model.addAttribute("error", "User already exists!");
            return "auth/register"; // Show the register page with an error message
        }
        User user = new User();
        user.setName(name);
        user.setEmail(email);
        user.setPassword(password); // In production, always hash passwords!
        user.setRole(role);
        userRepository.save(user);
        model.addAttribute("success", "User registered successfully!");
        
        System.out.println(user);
        // System.out.println("User registered successfully: " + user.getName() + ", " + user.getEmail() + ", " + user.getRole());
        
        return "auth/login"; // Redirect to the login page after successful registration


    }

    @GetMapping("/login")
    public String showLoginPage() {
        return "auth/login"; // Return the login.html page
    }

    @PostMapping("/login")
    public String loginUser(@RequestParam String email, @RequestParam String password, @RequestParam String role, Model model) {
        System.out.println("LoginUser Method called");
        System.out.println("Input email: " + email);
        System.out.println("Input password: " + password);
        System.out.println("Input role: " + role);

        User user = userRepository.findByEmail(email);
        if (user == null) {
            System.out.println("No user found with email: " + email);
        } else {
            System.out.println("User found: " + user);
            System.out.println("Stored password: " + user.getPassword());
            System.out.println("Stored role: " + user.getRole());
        }

        if (user != null && user.getPassword().equals(password) && user.getRole().equalsIgnoreCase(role)) {
            System.out.println("Password and role match. Login successful!");
            model.addAttribute("message", "Login successful!");

            // Redirect based on the user's role
            if (role.equalsIgnoreCase("customer")) {
                System.out.println("Redirecting to customer dashboard");
                return "dashboard/customer-dashboard"; // Redirect to the customer dashboard
            } else if (role.equalsIgnoreCase("agent")) {
                System.out.println("Redirecting to agent dashboard");
                return "dashboard/agent-dashboard"; // Redirect to the agent dashboard
            } else if (role.equalsIgnoreCase("admin")) {
                System.out.println("Redirecting to admin dashboard");
                return "dashboard/admin-dashboard"; // Redirect to the admin dashboard
            }
        }

        // If login fails, show an error message
        System.out.println("Login failed. Invalid email, password, or role!");
        model.addAttribute("error", "Invalid email, password, or role!");
        return "auth/login"; // Show the login page with an error message
    }
}