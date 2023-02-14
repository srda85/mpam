package com.srda.mpam.service.utilisateur;

import com.srda.mpam.model.dto.UtilisateurDTO;
import com.srda.mpam.model.form.utilisateur.UtilisateurForm;
import com.srda.mpam.model.form.utilisateur.UtilisateurUpdateForm;
import com.srda.mpam.service.CrudService;

public interface UtilisateurService extends CrudService <UtilisateurDTO, Long, UtilisateurForm, UtilisateurUpdateForm>{

}
