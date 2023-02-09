package com.srda.mpam.tools;


import com.srda.mpam.model.entity.Utilisateur;
import com.srda.mpam.repositories.UtilisateurRepository;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class DataInit implements InitializingBean {

    private final UtilisateurRepository utilisateurRepository;

    public DataInit(UtilisateurRepository utilisateurRepository) {
        this.utilisateurRepository=utilisateurRepository;
    }

    Utilisateur utilisateur1 = new Utilisateur("Seb","sceuba@gmail.com");
    Utilisateur utilisateur2 = new Utilisateur("Jean","Jean.lasalle@google.com");


    private final List<Utilisateur>utilisateurList=List.of(utilisateur1,utilisateur2);

    @Override
    public void afterPropertiesSet() throws Exception {
        utilisateurRepository.saveAllAndFlush(utilisateurList);
    }
}
