package com.srda.mpam.model.form.compteEtranger;

import lombok.Data;

@Data
public class CompteEtrangerForm {

    private Long id;
    private String accountNbr;
    private String etiquetteParDefaut;
    private String denominationOfficielle;
    private String nomPersonnalise;
    private String groupe;

}
