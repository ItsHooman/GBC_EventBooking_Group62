package com.gbc.eventbooking.ApprovalService.service;

import com.gbc.eventbooking.ApprovalService.client.EventServiceClient;
import com.gbc.eventbooking.ApprovalService.client.UserServiceClient;
import com.gbc.eventbooking.ApprovalService.model.Approval;
import com.gbc.eventbooking.ApprovalService.repository.ApprovalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApprovalService {

    @Autowired
    private ApprovalRepository approvalRepository;

    @Autowired
    private EventServiceClient eventServiceClient;

    @Autowired
    private UserServiceClient userServiceClient;

    public Approval approveOrRejectEvent(Approval approval, String role) {
        // Check if the user is authorized (only "staff" role can approve/reject)
        if (!"staff".equalsIgnoreCase(role)) {
            throw new IllegalArgumentException("Only staff members are authorized to approve or reject events.");
        }

        // Verify event details from EventService
        String eventId = approval.getEventId();
        Boolean eventExists = eventServiceClient.eventExists(eventId).getBody();

        if (eventExists == null || !eventExists) {
            throw new IllegalArgumentException("The specified event does not exist.");
        }

        // Verify user role from UserService
        String approverId = approval.getApproverId();
        String userRole = userServiceClient.getUserRole(approverId).getBody();

        if (userRole == null || !userRole.equalsIgnoreCase("staff")) {
            throw new IllegalArgumentException("Only staff members are allowed to approve or reject events.");
        }

        // Save the approval record
        return approvalRepository.save(approval);
    }

    public List<Approval> getAllApprovals() {
        return approvalRepository.findAll();
    }
}
