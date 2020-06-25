package com.scalefocus.workforcemanagement.events.publishers;

import com.scalefocus.workforcemanagement.entities.TimeOffRequest;
import com.scalefocus.workforcemanagement.events.time_off_request_events.RequestCanceledEvent;
import com.scalefocus.workforcemanagement.events.time_off_request_events.RequestCreatedEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

@Component
public class RequestEventPublisher {

    private final ApplicationEventPublisher publisher;

    public RequestEventPublisher(ApplicationEventPublisher publisher) {
        this.publisher = publisher;
    }

    public void publishRequestCreatedEvent(final TimeOffRequest timeOffRequest) {
        publisher.publishEvent(new RequestCreatedEvent(timeOffRequest));
    }

    public void publicRequestCanceledEvent(final TimeOffRequest timeOffRequest) {
        publisher.publishEvent(new RequestCanceledEvent(timeOffRequest));
    }
}
