package com.example.sms.service;

import com.example.sms.entity.Groupe;

import java.util.List;

public interface GroupeService {
    List<Groupe> getAllGroupes();

    Groupe saveGroupe(Groupe groupe);
    Groupe getGroupeById(Long groupeId);

    Groupe updateGroupe(Groupe groupe);
    void deleteGroupe(Long groupeId);
}
