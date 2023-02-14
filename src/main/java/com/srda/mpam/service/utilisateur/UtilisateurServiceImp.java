package com.srda.mpam.service.utilisateur;

import com.srda.mpam.exceptions.UtilisateurIntrouvableException;
import com.srda.mpam.mapper.UtilisateurMapper;
import com.srda.mpam.model.dto.UtilisateurDTO;
import com.srda.mpam.model.entity.Utilisateur;
import com.srda.mpam.model.form.utilisateur.UtilisateurForm;
import com.srda.mpam.model.form.utilisateur.UtilisateurUpdateForm;
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
    @Override
    public UtilisateurDTO update(Long id, UtilisateurUpdateForm toUpdate) {
        if (toUpdate == null || id == null)throw new IllegalArgumentException("toUpdate can't be null");
        Utilisateur utilisateur = utilisateurMapper.toEntityUpdate(toUpdate);

        //Je mets une vérification ici pour qu'il évite de créer un nouvel utilisateur dans le cas où l'update se fait avec un id qui n'existe pas encore.
        if(utilisateurRepository.findById(id).isEmpty())throw new UtilisateurIntrouvableException("Id utilisateur non trouvé");
        utilisateur.setId(id);
        utilisateurRepository.saveAndFlush(utilisateur);
        return utilisateurMapper.toDTO(utilisateur);
    }
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
