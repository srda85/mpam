package com.srda.mpam.model.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
public class Operation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Double montant;
    private LocalDate dateValeur;
    private Long refBanquaire;

    @ManyToOne
    private AccountUser accountUser;

    @ManyToOne
    private CompteEtranger compteEtranger;

    public Operation(Double montant, LocalDate dateValeur, Long refBanquaire, AccountUser accountUser, CompteEtranger compteEtranger) {
        this.montant = montant;
        this.dateValeur = dateValeur;
        this.refBanquaire = refBanquaire;
        this.accountUser = accountUser;
        this.compteEtranger = compteEtranger;
    }

    public Operation() {
    }
}
