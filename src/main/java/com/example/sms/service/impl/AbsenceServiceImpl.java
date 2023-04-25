package com.example.sms.service.impl;

import com.example.sms.entity.Absence;
import com.example.sms.repository. AbsenceRepository;
import com.example.sms.service. AbsenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AbsenceServiceImpl  implements AbsenceService {
    private AbsenceRepository absenceRepository;


    @Autowired
    public AbsenceServiceImpl(AbsenceRepository absenceRepository) {
        super();
        this.absenceRepository = absenceRepository;
    }



    @Override
    public List<Absence> getAllAbsences() {
        return absenceRepository.findAll();
    }



    @Override
    public Absence saveAbsence(Absence absence) {
        return absenceRepository.save(absence);
    }



    @Override
    public Absence getAbsenceById(Long absenceId) {
        return absenceRepository.findById(absenceId).get();
    }




    @Override
    public Absence updateAbsence(Absence absence) {
        return absenceRepository.save(absence);
    }



    @Override
    public void deleteAbsence(Long absenceId) {
        absenceRepository.deleteById(absenceId);
    }
}
