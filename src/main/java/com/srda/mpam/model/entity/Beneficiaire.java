package com.srda.mpam.model.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
public class Beneficiaire {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String groupe;


    public Beneficiaire(String name, String groupe) {
        this.name = name;
        this.groupe = groupe;
    }

    public Beneficiaire() {
    }
}


