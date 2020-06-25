package com.scalefocus.workforcemanagement.controllers.dtos.time_of_response;

import com.scalefocus.workforcemanagement.controllers.dtos.time_of_request.RequestShortDTO;
import com.scalefocus.workforcemanagement.controllers.dtos.user.UserShortDTO;
import lombok.Data;

@Data
public class ApprovalResponseDTO {

    private Long id;

    private RequestShortDTO request;

    private UserShortDTO approver;

    private boolean isApproved;
}
