package com.gbc.eventbooking.ApprovalService.controller;

import com.gbc.eventbooking.ApprovalService.model.Approval;
import com.gbc.eventbooking.ApprovalService.service.ApprovalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/approvals")
public class ApprovalController {

    @Autowired
    private ApprovalService approvalService;

    /**
     * Approve or reject an event. Only staff members are authorized to perform this action.
     *
     * @param approval The approval/rejection details for the event.
     * @param role The role of the user attempting to approve/reject the event (should be "staff").
     * @return The saved approval document if the user is authorized, otherwise an error is thrown.
     */
    @PostMapping
    public Approval approveOrRejectEvent(@RequestBody Approval approval, @RequestParam String role) {
        return approvalService.approveOrRejectEvent(approval, role);
    }

    /**
     * Retrieve all approval records.
     *
     * @return A list of all approvals in the system.
     */
    @GetMapping
    public List<Approval> getAllApprovals() {
        return approvalService.getAllApprovals();
    }
}
