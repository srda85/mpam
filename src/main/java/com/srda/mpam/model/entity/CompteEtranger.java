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
    private String denominationOfficielle;
    private String nomPersonnalise;
    private String groupe;


    public CompteEtranger(String accountNbr, String etiquetteParDefaut, String denominationOfficielle, String nomPersonnalise, String groupe) {
        this.accountNbr = accountNbr;
        this.etiquetteParDefaut = etiquetteParDefaut;
        this.denominationOfficielle = denominationOfficielle;
        this.nomPersonnalise = nomPersonnalise;
        this.groupe = groupe;
    }

    public CompteEtranger(String accountNbr, String denominationOfficielle, String nomPersonnalise, String groupe) {
        this.accountNbr = accountNbr;
        this.denominationOfficielle = denominationOfficielle;
        this.nomPersonnalise = nomPersonnalise;
        this.groupe = groupe;
    }

    //Crée uniquement pour l'algo de création automatique dans le PDfService
    public CompteEtranger(String denominationOfficielle) {
        this.denominationOfficielle = denominationOfficielle;
    }

    public CompteEtranger() {
    }
}
