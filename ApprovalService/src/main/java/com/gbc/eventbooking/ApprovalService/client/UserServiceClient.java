package com.gbc.eventbooking.ApprovalService.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.http.ResponseEntity;

@FeignClient(name = "user-service", url = "http://localhost:8083/api/users")  // Replace with the actual UserService URL or service name if using Docker Compose
public interface UserServiceClient {

    @GetMapping("/{userId}/role")
    ResponseEntity<String> getUserRole(@PathVariable("userId") String userId);
}
