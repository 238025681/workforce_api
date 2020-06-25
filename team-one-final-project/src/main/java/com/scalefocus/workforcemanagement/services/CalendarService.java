package com.scalefocus.workforcemanagement.services;

import java.time.LocalDate;

public interface CalendarService {
   Integer getNumberOfWorkingDays (LocalDate startDate, LocalDate endDate);
}
