package com.srda.mpam.model.form.compteEtranger;

import com.srda.mpam.model.entity.Beneficiaire;
import lombok.Data;

@Data
public class CompteEtrangerFormUpdate {

    private Long id;
    private String accountNbr;
    private String etiquetteParDefaut;
    private Long beneficiaireId;
}
