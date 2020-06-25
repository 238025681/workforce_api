package com.scalefocus.workforcemanagement.controllers.dtos.user;

import com.scalefocus.workforcemanagement.controllers.dtos.team.TeamShortDTO;
import com.scalefocus.workforcemanagement.controllers.enums.LeaveType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;
import java.util.Map;
import java.util.Set;

@Getter @Setter @NoArgsConstructor
public class UserResponseDTO {

    private Long id;

    private String email;

    private Map<LeaveType, Integer> remainingDaysOff;

    private Set<TeamShortDTO> teams;

    private String username;

    private String firstName;

    private String lastName;

    private boolean isAdmin;

    private boolean onLeave;

    private Instant createdAt;

    private UserShortDTO createdBy;

    private Instant updatedAt;

    private UserShortDTO updatedBy;
}
