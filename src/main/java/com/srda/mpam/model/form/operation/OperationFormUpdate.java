package com.srda.mpam.model.form.operation;


import lombok.Data;

import java.time.LocalDate;

@Data
public class OperationFormUpdate {
    private Long id;
    private Double montant;
    private LocalDate dateValeur;
    private Long refBanquaire;
    private Long accountUserId;
    private Long compteEtrangerId;

}
