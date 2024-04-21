package com.example.javaproject.User;

import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // Existing authenticateUser method

    public User registerUser(User user) {
        // Check if the email already exists
        User existingUser = userRepository.findByEmail(user.getEmail());
        if (existingUser != null) {
            // Email already exists, handle the error or throw an exception
            throw new RuntimeException("Email already registered");
        }

        // Save the new user
        return userRepository.save(user);
    }
    public boolean authenticateUser(String userName, String password) {
        // Retrieve the user from the database based on the username
        User user = userRepository.findByUserName(userName);

        // Check if the user exists and if the provided password matches the stored password
        return user != null && user.getPassword().equals(password);
    }
}