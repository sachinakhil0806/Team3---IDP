package com.project.InsuranceManagementSystem.Controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;

@Controller
public class CustomerController {
    @RequestMapping("home")
    public String showHome() {
        return "auth/home"; // Returns the login page view
    }

    @RequestMapping("login")
    public String showLoginPage() {
        return "auth/login"; // Returns the login page view
    }

    @RequestMapping("register")
    public String showRegisterPage() {
        return "auth/register"; // Returns the register page view
    }

  
}
