package com.gbc.eventbooking.UserService.service;

import com.gbc.eventbooking.UserService.model.User;
import com.gbc.eventbooking.UserService.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public Optional<User> getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public boolean isUserAuthorizedToApprove(String email) {
        Optional<User> userOptional = userRepository.findByEmail(email);
        return userOptional.map(user -> "staff".equalsIgnoreCase(user.getRole())).orElse(false);
    }
}
