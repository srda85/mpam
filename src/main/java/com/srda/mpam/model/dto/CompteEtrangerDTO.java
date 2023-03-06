package com.srda.mpam.model.dto;

import lombok.Builder;
import lombok.Data;



@Data
@Builder
public class CompteEtrangerDTO {


    private Long id;
    private String accountNbr;
    private String etiquetteParDefaut;
    private String denominationOfficielle;
    private String nomPersonnalise;
    private String groupe;



}
