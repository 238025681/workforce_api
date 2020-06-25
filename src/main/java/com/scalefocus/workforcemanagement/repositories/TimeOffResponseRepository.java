package com.scalefocus.workforcemanagement.repositories;

import com.scalefocus.workforcemanagement.entities.TimeOffResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TimeOffResponseRepository extends JpaRepository<TimeOffResponse, Long> {
    TimeOffResponse findByIdAndApproverId(Long responseId, Long approverId);
    Page<TimeOffResponse> findAllByApproverId(Pageable pageable, Long approverId);
}
