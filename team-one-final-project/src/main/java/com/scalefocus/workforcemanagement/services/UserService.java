package com.scalefocus.workforcemanagement.services;

import com.scalefocus.workforcemanagement.controllers.dtos.user.UserRequestDTO;
import com.scalefocus.workforcemanagement.controllers.dtos.user.UserResponseDTO;
import com.scalefocus.workforcemanagement.entities.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface UserService {

    Page<UserResponseDTO> getAll(Pageable pageable);
    List<UserResponseDTO> getAll();

    UserResponseDTO getUserById(long userId);

    User getById(Long id);

    UserResponseDTO createUser(UserRequestDTO userDTO);

    UserResponseDTO updateUser(Long userId, UserRequestDTO userRequestDTO);

    Integer deleteById(Long userId);

    boolean isTeamLeader(Long userId);

    boolean isUsersCreator(Long userId);

    boolean isTeamsCreator(Long userId);

    boolean isRequestsCreator(Long userId);

}
