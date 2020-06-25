package com.scalefocus.workforcemanagement.services;

import com.scalefocus.workforcemanagement.entities.User;
import com.scalefocus.workforcemanagement.security.CustomUserPrincipal;

public interface TokenService {

    String generateToken(User user);

    CustomUserPrincipal parseToken(String token);
}
