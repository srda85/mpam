package com.srda.mpam.model.entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Email;

@Entity
//@Table(name= "user")
@Data
public class Utilisateur {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
//    Validateur email
    @Email
    private String email;


    public Utilisateur() {
    }

    public Utilisateur(String nom, String email) {
    this.name=nom;
    this.email=email;
    }
}
