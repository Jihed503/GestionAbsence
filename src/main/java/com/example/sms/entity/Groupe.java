package com.example.sms.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="groupe")
public class Groupe {
    @Id
    private Long id;

    @Column(name="nom")
    private String name;

    public Groupe() {
    }

    public Groupe(String name) {
        this.name = name;
    }

    public Groupe(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

