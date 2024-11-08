package com.gbc.eventbooking.EventService.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "user-service", url = "http://localhost:8087/users")
public interface UserServiceClient {

    @GetMapping("/{email}/role")
    String getUserRole(@PathVariable("email") String email);
}
