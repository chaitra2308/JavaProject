package com.example.javaproject.User;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new User());
        return "registration"; // Assuming the registration HTML template is named "registration.html"
    }

    @PostMapping("/register")
    public String registerUser(@ModelAttribute User user, Model model) {
        try {
            User registeredUser = userService.registerUser(user);
            model.addAttribute("successMessage", "Registration successful!");
            // You can optionally add the registered user to the model for further processing
            model.addAttribute("registeredUser", registeredUser);
        } catch (RuntimeException e) {
            model.addAttribute("errorMessage", e.getMessage());
        }
        return "login" ; // Return the same registration page
    }
   @PostMapping("/login")
   public String loginUser(@ModelAttribute("loginForm") LoginForm loginForm, Model model) {
        // Check if the credentials are correct
        if (userService.authenticateUser(loginForm.getUserName(), loginForm.getPassword())) {
            // If credentials are correct, redirect to a different page
            return "redirect:/feedback"; // Redirect to the home page
        } else {
            // If credentials are incorrect, show an error message
            model.addAttribute("errorMessage", "Invalid username or password");
            return "login";
        }
    }
   @GetMapping("/login")
    public String showLoginPage(Model model) {
        model.addAttribute("loginForm", new LoginForm());
return "login";
    }

}