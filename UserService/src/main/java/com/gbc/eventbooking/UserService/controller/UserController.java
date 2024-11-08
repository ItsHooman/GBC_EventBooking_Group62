package com.gbc.eventbooking.UserService.controller;

import com.gbc.eventbooking.UserService.model.User;
import com.gbc.eventbooking.UserService.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public User createUser(@RequestBody User user) {
        return userService.createUser(user);
    }

    @GetMapping("/{email}")
    public Optional<User> getUserByEmail(@PathVariable String email) {
        return userService.getUserByEmail(email);
    }

    @GetMapping("/{email}/can-approve")
    public boolean canUserApprove(@PathVariable String email) {
        return userService.isUserAuthorizedToApprove(email);
    }
}
