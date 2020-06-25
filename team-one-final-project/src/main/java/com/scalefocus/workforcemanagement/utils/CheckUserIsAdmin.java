package com.scalefocus.workforcemanagement.utils;

import com.scalefocus.workforcemanagement.entities.User;
import com.scalefocus.workforcemanagement.repositories.UserRepository;
import com.scalefocus.workforcemanagement.services.AuthenticationService;
import com.scalefocus.workforcemanagement.services.exceptions.NotFoundUserByIdException;
import com.scalefocus.workforcemanagement.services.exceptions.UnauthorizedUserException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("checkUserIsAdmin")
public class CheckUserIsAdmin {

    private final AuthenticationService authenticationService;
    private final UserRepository userRepo;

    @Autowired
    public CheckUserIsAdmin(AuthenticationService authenticationService, UserRepository userRepo) {
        this.authenticationService = authenticationService;
        this.userRepo = userRepo;
    }

    public boolean isUserAdmin(Long userId) {
       User user = userRepo.findById(userId).orElseThrow(() -> new NotFoundUserByIdException(userId));
        User logUser = authenticationService.getLoggedUser();
        if (!user.getId().equals(logUser.getId())){
            if (!logUser.isAdmin()) {
                throw new UnauthorizedUserException("User must be admin or creator!!!");
            }
        }

        return true;
    }
}
