package com.example.sms.service;

import com.example.sms.entity.Absence;

import java.util.List;

public interface AbsenceService {
    List<Absence> getAllAbsences();
    Absence saveAbsence(Absence absence);
    Absence getAbsenceById(Long absenceId);

    Absence updateAbsence(Absence absence);
    void deleteAbsence(Long absenceId);
}
