package com.srda.mpam.model.dto;

import com.srda.mpam.model.entity.Beneficiaire;
import lombok.Builder;
import lombok.Data;



@Data
@Builder
public class CompteEtrangerDTO {


    private Long id;
    private String accountNbr;
    private String etiquetteParDefaut;
    private Beneficiaire beneficiaire;



}
