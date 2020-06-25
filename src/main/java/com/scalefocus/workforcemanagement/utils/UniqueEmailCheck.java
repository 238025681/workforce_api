package com.scalefocus.workforcemanagement.utils;

import com.scalefocus.workforcemanagement.repositories.UserRepository;
import com.scalefocus.workforcemanagement.services.exceptions.NotUniqueEmailException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("uniqueEmailCheck")
public class UniqueEmailCheck {

    private final UserRepository userRepository;

    @Autowired
    public UniqueEmailCheck(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Boolean isUniqueEmail(String email, Long userId){
        Boolean existsEmail = this.userRepository.existsByEmail(email);
        Boolean existsByEmailAndId = this.userRepository.existsByEmailAndId(email, userId);

        if (!existsEmail){
            return Boolean.TRUE;
        }

        if (!existsByEmailAndId){
            throw new NotUniqueEmailException();
        }

        return true;
    }
}
