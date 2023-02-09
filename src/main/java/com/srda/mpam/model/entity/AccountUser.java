package com.srda.mpam.model.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
public class AccountUser {


    @Id
    private Long id;
    private String accountNumber;
    private String type;

}
