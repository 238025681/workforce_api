package com.scalefocus.workforcemanagement.events.time_off_response_events;

import com.scalefocus.workforcemanagement.entities.TimeOffRequest;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ApprovedRequestEvent {
    private TimeOffRequest timeOffRequest;

    public ApprovedRequestEvent(TimeOffRequest timeOffRequest) {
        this.timeOffRequest = timeOffRequest;
    }
}
