package com.gbc.eventbooking.ApprovalService.service;

import com.gbc.eventbooking.ApprovalService.model.Approval;
import com.gbc.eventbooking.ApprovalService.repository.ApprovalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApprovalService {

    @Autowired
    private ApprovalRepository approvalRepository;

    public Approval approveOrRejectEvent(Approval approval, String role) {
        if (!"staff".equalsIgnoreCase(role)) {
            throw new IllegalArgumentException("Only staff members are authorized to approve or reject events.");
        }
        return approvalRepository.save(approval);
    }

    public List<Approval> getAllApprovals() {
        return approvalRepository.findAll();
    }
}
