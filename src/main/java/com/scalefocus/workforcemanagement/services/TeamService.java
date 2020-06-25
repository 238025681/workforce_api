package com.scalefocus.workforcemanagement.services;

import com.scalefocus.workforcemanagement.controllers.dtos.team.TeamRequestDTO;
import com.scalefocus.workforcemanagement.controllers.dtos.team.TeamResponseDTO;
import com.scalefocus.workforcemanagement.controllers.dtos.user.UserShortDTO;
import com.scalefocus.workforcemanagement.entities.Team;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface TeamService {
    List<TeamResponseDTO> getAll();

    TeamResponseDTO getTeamById(long teamId);

    Team getById(long teamId);

    TeamResponseDTO edit(long teamId, TeamRequestDTO teamRequestDTO );

    TeamResponseDTO create(TeamRequestDTO teamRequestDTO);

    Integer deleteById(long teamId);

    List<UserShortDTO>  assignMember(long memberId, long teamId);

    List<UserShortDTO>  unassignMember(long memberId, long teamId);

    Page<TeamResponseDTO> getAll(Pageable pageable);
}
