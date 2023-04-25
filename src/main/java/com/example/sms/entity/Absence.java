package com.example.sms.entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "absence")
public class Absence {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "cin", nullable=false)
    private Long cin;

    @Column(name = "nom")
    private String name;

    @Column(name = "prenom")
    private String firstName;


    @Column(name = "date")
    private LocalDate date;


    @Column(name = "groupe")
    private String groupe;

    @Column(name = "present")
    private boolean present;

    public Absence() {
    }

    public Absence(Long cin, LocalDate date, boolean present) {
        this.cin = cin;
        this.date = date;
        this.present = present;
    }

    public Absence(Long cin, String name, String firstName, LocalDate date, String groupe, boolean present) {
        this.cin = cin;
        this.name = name;
        this.firstName = firstName;
        this.date = date;
        this.groupe = groupe;
        this.present = present;
    }

    public Absence(Long id, Long cin, String name, String firstName, LocalDate date, String groupe) {
        this.id = id;
        this.cin = cin;
        this.name = name;
        this.firstName = firstName;
        this.date = date;
        this.groupe = groupe;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCin() {
        return cin;
    }

    public void setCin(Long cin) {
        this.cin = cin;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }



    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }





    public String getGroupe() {
        return groupe;
    }

    public void setGroupe(String groupe) {
        this.groupe = groupe;
    }
}
