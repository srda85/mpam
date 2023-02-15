package com.srda.mpam.mapper;

import com.srda.mpam.model.dto.CompteEtrangerDTO;
import com.srda.mpam.model.entity.CompteEtranger;
import com.srda.mpam.model.form.compteEtranger.CompteEtrangerForm;
import com.srda.mpam.model.form.compteEtranger.CompteEtrangerFormUpdate;
import com.srda.mpam.repositories.BeneficiaireRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CompteEtrangerMapper {

    @Autowired
    BeneficiaireRepository beneficiaireRepository;

    public CompteEtrangerDTO toDto(CompteEtranger compteEtranger){
        return CompteEtrangerDTO.builder()
                .id(compteEtranger.getId())
                .accountNbr(compteEtranger.getAccountNbr())
                .etiquetteParDefaut(compteEtranger.getEtiquetteParDefaut())
                .beneficiaire(compteEtranger.getBeneficiaire())
                .build();
    }

    public CompteEtranger toEntity(CompteEtrangerForm compteEtrangerForm){
        return new CompteEtranger(
                compteEtrangerForm.getAccountNbr(),
                compteEtrangerForm.getEtiquetteParDefaut(),
                beneficiaireRepository.findById(compteEtrangerForm.getBeneficiaireId()).orElseThrow(()->new RuntimeException("BeneficiaireId not found"))
        );
    }

    public CompteEtranger toEntityUpdate(CompteEtrangerFormUpdate compteEtrangerFormUpdate){
        return new CompteEtranger(
                compteEtrangerFormUpdate.getAccountNbr(),
                compteEtrangerFormUpdate.getEtiquetteParDefaut(),
                beneficiaireRepository.findById(compteEtrangerFormUpdate.getBeneficiaireId()).orElseThrow(()->new RuntimeException("BeneficiaireId not found"))
        );
    }

}
