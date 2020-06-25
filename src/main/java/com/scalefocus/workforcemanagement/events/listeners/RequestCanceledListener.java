package com.scalefocus.workforcemanagement.events.listeners;

import com.scalefocus.workforcemanagement.controllers.enums.LeaveType;
import com.scalefocus.workforcemanagement.controllers.enums.Status;
import com.scalefocus.workforcemanagement.entities.TimeOffRequest;
import com.scalefocus.workforcemanagement.entities.User;
import com.scalefocus.workforcemanagement.events.time_off_request_events.RequestCanceledEvent;
import com.scalefocus.workforcemanagement.repositories.UserRepository;
import com.scalefocus.workforcemanagement.services.CalendarService;
import com.scalefocus.workforcemanagement.services.EmailService;
import com.scalefocus.workforcemanagement.services.exceptions.NotFoundUserByIdException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class RequestCanceledListener {

    private final EmailService emailService;

    private final CalendarService calendarService;

    private final UserRepository userRepository;

    @Value("${email.message.canceled.to.team_leaders}")
    String messageToTeamLeaders;

    @Autowired
    public RequestCanceledListener(EmailService emailService,
                                   CalendarService calendarService,
                                   UserRepository userRepository) {
        this.emailService = emailService;
        this.calendarService = calendarService;
        this.userRepository = userRepository;
    }

    @EventListener
    public void handleRequestCanceled(RequestCanceledEvent event) {
        TimeOffRequest timeOffRequest = event.getTimeOffRequest();
        User requester = userRepository.findById(timeOffRequest.getRequesterId())
                .orElseThrow(() -> new NotFoundUserByIdException(timeOffRequest.getRequesterId()));

        if (timeOffRequest.getStatus().equals(Status.APPROVED)) {
            LocalDate startDate = timeOffRequest.getStartDate();
            LocalDate endDate = timeOffRequest.getEndDate();
            LocalDate currentDate = LocalDate.now();
            int leaveDaysAllowance = timeOffRequest.getLeaveWorkDays();

            if (currentDate.isBefore(startDate) || timeOffRequest.getLeaveType().equals(LeaveType.SICK_LEAVE)) {
                restoreRemainingDaysOff(timeOffRequest, requester, leaveDaysAllowance);
            } else if (currentDate.isAfter(startDate) && currentDate.isBefore(endDate)) {
                int workingDaysPast = calendarService.getNumberOfWorkingDays(startDate, currentDate);
                leaveDaysAllowance -= workingDaysPast;
                restoreRemainingDaysOff(timeOffRequest, requester, leaveDaysAllowance);
            }
        }

        setStatusCanceled(timeOffRequest);

        sendEmailToTeamLeaders(requester);
    }

    private void sendEmailToTeamLeaders(User requester) {
        emailService.sendEmails(userRepository.findAllTeamLeaderEmailsForCurrentUser(requester.getId()),
                requester.getUsername(), String.format(messageToTeamLeaders, requester.getFirstName()));
    }

    private void restoreRemainingDaysOff(TimeOffRequest timeOffRequest, User requester, int leaveDaysAllowance) {
        requester.getRemainingDaysOff().compute(timeOffRequest.getLeaveType(), (k, v) -> v += leaveDaysAllowance);
        userRepository.save(requester);
    }

    private void setStatusCanceled(TimeOffRequest timeOffRequest) {
        timeOffRequest.setStatus(Status.CANCELED);
    }
}
