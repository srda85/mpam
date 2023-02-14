package com.srda.mpam.mapper;

import com.srda.mpam.model.dto.UtilisateurDTO;
import com.srda.mpam.model.entity.Utilisateur;
import com.srda.mpam.model.form.utilisateur.UtilisateurForm;
import com.srda.mpam.model.form.utilisateur.UtilisateurUpdateForm;
import com.srda.mpam.repositories.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UtilisateurMapper {

    @Autowired
    UtilisateurRepository utilisateurRepository;

    public  UtilisateurDTO toDTO(Utilisateur utilisateur){
        return UtilisateurDTO.builder()
                .id(utilisateur.getId())
                .email(utilisateur.getEmail())
                .name(utilisateur.getName())
                .build();
    }

    public Utilisateur toEntity(UtilisateurForm utilisateurForm){
        return new Utilisateur(
                utilisateurForm.getName(),
                utilisateurForm.getEmail()
        );
    }

    public Utilisateur toEntityUpdate(UtilisateurUpdateForm utilisateurUpdateForm){
        return new Utilisateur(
                utilisateurUpdateForm.getName(),
                utilisateurUpdateForm.getEmail()
        );
    }
}
