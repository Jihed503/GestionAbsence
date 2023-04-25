package com.example.sms.service.impl;

import com.example.sms.entity.Groupe;
import com.example.sms.entity.Student;
import com.example.sms.repository.GroupeRepository;
import com.example.sms.service.GroupeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GroupeServiceImpl implements GroupeService {
    private GroupeRepository groupeRepository;

    @Autowired
    public GroupeServiceImpl(GroupeRepository groupeRepository){
        super();
        this.groupeRepository = groupeRepository;
    }

    @Override
    public List<Groupe> getAllGroupes() { return groupeRepository.findAll();}



    @Override
    public Groupe saveGroupe(Groupe groupe) {
        return groupeRepository.save(groupe);
    }



    @Override
    public Groupe getGroupeById(Long groupeId) {
        return groupeRepository.findById(groupeId).get();
    }




    @Override
    public Groupe updateGroupe(Groupe groupe) {
        return groupeRepository.save(groupe);
    }



    @Override
    public void deleteGroupe(Long groupeId) {
        groupeRepository.deleteById(groupeId);
    }


}
