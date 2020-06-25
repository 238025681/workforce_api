package com.scalefocus.workforcemanagement.controllers.dtos.team;

import com.scalefocus.workforcemanagement.services.PostValidation;
import com.scalefocus.workforcemanagement.services.PutValidation;
import com.scalefocus.workforcemanagement.services.exceptions.UniqueTitle;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

@Getter @Setter
public class TeamRequestDTO {

    @UniqueTitle(message = "error.request.title.unique", groups = PostValidation.class)
    @NotEmpty(message = "error.request.title.empty", groups = {PostValidation.class, PutValidation.class})
    private String title;

    @NotBlank(message = "error.request.description.empty", groups = {PostValidation.class, PutValidation.class})
    private String description;

    @Min(value = 1, message = "error.request.teamleaderid.negative", groups = {PostValidation.class, PutValidation.class})
    private Long teamLeaderId;
}
