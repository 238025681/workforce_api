package com.scalefocus.workforcemanagement.services.exceptions.validators;

import com.scalefocus.workforcemanagement.repositories.TeamRepository;
import com.scalefocus.workforcemanagement.services.exceptions.UniqueTitle;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UniqueTeamTitleValidator implements ConstraintValidator<UniqueTitle, String> {

    private final TeamRepository teamRepository;

    public UniqueTeamTitleValidator(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }

    @Override
    public void initialize(UniqueTitle constraintAnnotation) {
    }

    @Override
    public boolean isValid(String title, ConstraintValidatorContext constraintValidatorContext) {
        return !teamRepository.existsByTitle(title);
    }
}
