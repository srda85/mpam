package com.srda.mpam.mapper;


import com.srda.mpam.model.dto.BeneficiaireDTO;
import com.srda.mpam.model.entity.Beneficiaire;
import com.srda.mpam.model.form.beneficiaire.BeneficiaireForm;
import com.srda.mpam.model.form.beneficiaire.BeneficiaireUpdateForm;
import org.springframework.stereotype.Component;

@Component
public class BeneficiaireMapper {

    public BeneficiaireDTO toDto(Beneficiaire beneficiaire){
        return BeneficiaireDTO.builder()
                .id(beneficiaire.getId())
                .name(beneficiaire.getName())
                .groupe(beneficiaire.getGroupe())
                .build();
    }

    public Beneficiaire toEntity(BeneficiaireForm form){
        return new Beneficiaire(
                form.getName(),
                form.getGroupe());
    }

    public Beneficiaire toEntityUpdate(BeneficiaireUpdateForm updateForm){
        return new Beneficiaire(updateForm.getName(), updateForm.getGroupe());
    }



}
