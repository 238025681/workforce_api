package com.scalefocus.workforcemanagement.controllers.dtos.time_of_request;

import com.scalefocus.workforcemanagement.controllers.dtos.time_of_response.ShortApprovalResponseDTO;
import com.scalefocus.workforcemanagement.controllers.dtos.user.UserShortDTO;
import com.scalefocus.workforcemanagement.controllers.enums.LeaveType;
import com.scalefocus.workforcemanagement.controllers.enums.Status;
import lombok.Data;

import java.time.Instant;
import java.time.LocalDate;
import java.util.List;

@Data
public class TimeOffRequestResponseDTO {

    private Long id;

    private LeaveType leaveType;

    private Status status;

    private UserShortDTO requester;

    private LocalDate startDate;

    private LocalDate endDate;

    private String reason;

    private Integer leaveWorkDays;

    private List<ShortApprovalResponseDTO> responses;

    private Instant createdAt;

    private UserShortDTO createdBy;

    private Instant updatedAt;

    private UserShortDTO updatedBy;
}
