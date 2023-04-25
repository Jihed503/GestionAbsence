package com.example.sms.repository;

import com.example.sms.entity.Groupe;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GroupeRepository  extends JpaRepository<Groupe, Long> {
    List<Groupe> findByName(String name);
}
