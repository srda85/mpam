package com.srda.mpam.service.utilisateur;

import com.srda.mpam.exceptions.UtilisateurIntrouvableException;
import com.srda.mpam.mapper.UtilisateurMapper;
import com.srda.mpam.model.dto.UtilisateurDTO;
import com.srda.mpam.model.entity.Utilisateur;
import com.srda.mpam.model.form.UtilisateurForm;
import com.srda.mpam.repositories.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UtilisateurServiceImp implements UtilisateurService {

    @Autowired
    UtilisateurMapper utilisateurMapper;
    @Autowired
    UtilisateurRepository utilisateurRepository;

    @Override
    public List<UtilisateurDTO> getAll() {
      return utilisateurRepository.findAll().stream().map(utilisateurMapper::toDTO).toList();
    }
    @Override
    public UtilisateurDTO getOne(Long id) {
        return utilisateurRepository
                .findById(id)
                .map(utilisateurMapper::toDTO)
                .orElseThrow(()-> new UtilisateurIntrouvableException("utilisateur non trouvé"));
    }


    @Override
    public UtilisateurDTO create(UtilisateurForm toInsert) {
        return utilisateurMapper.toDTO(utilisateurRepository.save(utilisateurMapper.toEntity(toInsert)));
    }
//
//    @Override
//    public Object update(Object id, Object toUpdate) {
//        return null;
//    }
//
//
//
//
//
    @Override
    public void delete(Long id) {
        Utilisateur utilisateur=utilisateurRepository.findById(id).orElseThrow(()->new UtilisateurIntrouvableException("utilisateur non trouvé"));
        utilisateurRepository.delete(utilisateur);

    }
}
