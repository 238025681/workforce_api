package com.scalefocus.workforcemanagement.services;

import com.scalefocus.workforcemanagement.controllers.dtos.time_of_response.ApprovalRequestDTO;
import com.scalefocus.workforcemanagement.controllers.dtos.time_of_response.ApprovalResponseDTO;
import com.scalefocus.workforcemanagement.entities.TimeOffResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface TimeOffResponseService {

    List<ApprovalResponseDTO> getAll();

    ApprovalResponseDTO getResponseById(long responseId);

    TimeOffResponse getById(Long responseId);

    ApprovalResponseDTO create(Long timeOffRequestId, ApprovalRequestDTO approvalRequestDTO);

    Page<ApprovalResponseDTO> getAll(Pageable pageable);
}
