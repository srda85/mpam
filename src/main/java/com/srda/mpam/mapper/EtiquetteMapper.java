package com.srda.mpam.mapper;

import com.srda.mpam.model.dto.EtiquetteDTO;
import com.srda.mpam.model.entity.Etiquette;
import com.srda.mpam.model.form.etiquette.EtiquetteForm;
import com.srda.mpam.model.form.etiquette.EtiquetteFormUpdate;
import com.srda.mpam.repositories.EtiquetteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EtiquetteMapper {

    @Autowired
    EtiquetteRepository etiquetteRepository;


    public EtiquetteDTO toDto(Etiquette etiquette){
        return EtiquetteDTO.builder()
                .id(etiquette.getId())
                .nom(etiquette.getNom())
                .build();
    }

    public Etiquette toEntity(EtiquetteForm etiquetteForm){
        return new Etiquette(
                etiquetteForm.getNom()
        );
    }
    public Etiquette toEntityUpdate(EtiquetteFormUpdate etiquetteFormUpdate){
        return new Etiquette(
                etiquetteFormUpdate.getNom()
        );
    }

}
