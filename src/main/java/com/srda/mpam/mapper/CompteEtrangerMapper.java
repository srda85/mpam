package com.srda.mpam.mapper;

import com.srda.mpam.model.dto.CompteEtrangerDTO;
import com.srda.mpam.model.entity.CompteEtranger;
import com.srda.mpam.model.form.compteEtranger.CompteEtrangerForm;
import com.srda.mpam.model.form.compteEtranger.CompteEtrangerFormUpdate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CompteEtrangerMapper {



    public CompteEtrangerDTO toDto(CompteEtranger compteEtranger){
        return CompteEtrangerDTO.builder()
                .id(compteEtranger.getId())
                .accountNbr(compteEtranger.getAccountNbr())
                .etiquetteParDefaut(compteEtranger.getEtiquetteParDefaut())
                .build();
    }

    public CompteEtranger toEntity(CompteEtrangerForm compteEtrangerForm){
        return new CompteEtranger(
                compteEtrangerForm.getAccountNbr(),
                compteEtrangerForm.getGroupe(),
                compteEtrangerForm.getEtiquetteParDefaut(),
                compteEtrangerForm.getDenominationOfficielle(),
                compteEtrangerForm.getNomPersonnalise()
        );
    }

    public CompteEtranger toEntityUpdate(CompteEtrangerFormUpdate compteEtrangerFormUpdate){
        return new CompteEtranger(
                compteEtrangerFormUpdate.getAccountNbr(),
                compteEtrangerFormUpdate.getGroupe(),
                compteEtrangerFormUpdate.getEtiquetteParDefaut(),
                compteEtrangerFormUpdate.getDenominationOfficielle(),
                compteEtrangerFormUpdate.getNomPersonnalise()
        );
    }

}
