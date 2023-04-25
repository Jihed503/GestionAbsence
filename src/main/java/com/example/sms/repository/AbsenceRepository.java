package com.example.sms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.sms.entity.Absence;

public interface AbsenceRepository extends JpaRepository<Absence, Long> {

}
