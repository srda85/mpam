package com.srda.mpam.model.dto;

import com.srda.mpam.model.entity.AccountUser;
import com.srda.mpam.model.entity.CompteEtranger;
import lombok.Builder;
import lombok.Data;

import javax.persistence.ManyToOne;
import java.time.LocalDate;

@Data
@Builder
public class OperationDto {

    private Long id;
    private Double montant;
    private LocalDate dateValeur;
    private Long refBanquaire;
    private Long accountUserId;
    private Long compteEtrangerId;

}
