package com.incamp.companyprojects;

import javax.persistence.*;
import java.time.LocalDateTime;

public interface ContributionProjectDTO {
    Integer getId();
    Integer getProjectId();
    String getProjectName();
    Integer getPersonId();
    LocalDateTime getStartDate();
    LocalDateTime getEndDate();
}
