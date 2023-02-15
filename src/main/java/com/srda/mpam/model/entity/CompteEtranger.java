package com.srda.mpam.model.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class CompteEtranger {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String accountNbr;
    private String etiquetteParDefaut;

    @ManyToOne
    private Beneficiaire beneficiaire;


    public CompteEtranger(String accountNbr, String etiquetteParDefaut, Beneficiaire beneficiaire) {
        this.accountNbr = accountNbr;
        this.etiquetteParDefaut = etiquetteParDefaut;
        this.beneficiaire = beneficiaire;
    }

    public CompteEtranger() {
    }
}
