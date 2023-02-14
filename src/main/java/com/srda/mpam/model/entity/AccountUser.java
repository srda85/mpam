package com.srda.mpam.model.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class AccountUser {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String accountNumber;
    private Long solde;

    @ManyToOne
    private Utilisateur utilisateur;


    //mis ce constructeur mais pe supprimé pe plus tard
    public AccountUser(String accountNumber, Long solde) {
        this.accountNumber = accountNumber;
        this.solde = solde;
    }

    public AccountUser(Utilisateur utilisateur,String accountNumber, Long solde) {
        this.accountNumber = accountNumber;
        this.solde = solde;
        this.utilisateur=utilisateur;
    }

    public AccountUser() {

    }
}
