package com.gbc.eventbooking.ApprovalService.repository;

import com.gbc.eventbooking.ApprovalService.model.Approval;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApprovalRepository extends MongoRepository<Approval, String> {
    // Custom queries can be added here if needed
}
