package com.scalefocus.workforcemanagement.services;

import com.scalefocus.workforcemanagement.controllers.dtos.login.LoginRequestDTO;
import com.scalefocus.workforcemanagement.controllers.dtos.login.LoginResponseDTO;
import com.scalefocus.workforcemanagement.entities.User;

public interface AuthenticationService {

    LoginResponseDTO login(LoginRequestDTO loginRequestDTO);

    boolean userIsLoggedIn();

    User getLoggedUser();
}
