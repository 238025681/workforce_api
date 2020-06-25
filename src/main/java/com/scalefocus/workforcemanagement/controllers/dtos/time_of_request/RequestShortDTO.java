package com.scalefocus.workforcemanagement.controllers.dtos.time_of_request;

import com.scalefocus.workforcemanagement.controllers.enums.LeaveType;
import com.scalefocus.workforcemanagement.controllers.enums.Status;
import lombok.Data;

@Data
public class RequestShortDTO {

    private long id;

    private LeaveType leaveType;

    private Status status;

    private String requester;
}
