package com.srda.mpam.tools;


import com.srda.mpam.model.entity.AccountUser;
import com.srda.mpam.model.entity.Beneficiaire;
import com.srda.mpam.model.entity.Etiquette;
import com.srda.mpam.model.entity.Utilisateur;
import com.srda.mpam.repositories.AccountUserRepository;
import com.srda.mpam.repositories.BeneficiaireRepository;
import com.srda.mpam.repositories.EtiquetteRepository;
import com.srda.mpam.repositories.UtilisateurRepository;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class DataInit implements InitializingBean {

    private final UtilisateurRepository utilisateurRepository;
    private final AccountUserRepository accountUserRepository;
    private final BeneficiaireRepository beneficiaireRepository;
    private final EtiquetteRepository etiquetteRepository;

    public DataInit(UtilisateurRepository utilisateurRepository, AccountUserRepository accountUserRepository, BeneficiaireRepository beneficiaireRepository, EtiquetteRepository etiquetteRepository) {
        this.utilisateurRepository=utilisateurRepository;
        this.accountUserRepository = accountUserRepository;
        this.beneficiaireRepository = beneficiaireRepository;
        this.etiquetteRepository = etiquetteRepository;
    }

//region Utilisateur
    Utilisateur utilisateur1 = new Utilisateur("Seb","sceuba@gmail.com");
    Utilisateur utilisateur2 = new Utilisateur("Jean","Jean.lasalle@google.com");
    private final List<Utilisateur>utilisateurList=List.of(utilisateur1,utilisateur2);
//endregion

//region Account User
    AccountUser accountUser1=new AccountUser(utilisateur1,"818-941634-42",0L);
    AccountUser accountUser2=new AccountUser(utilisateur1,"123-941634-48",150L);
    private final List<AccountUser>accountUserList=List.of(accountUser1,accountUser2);
//endregion

//region beneficiaire

    Beneficiaire beneficiaire1 = new Beneficiaire("Jean","Privé");
    Beneficiaire beneficiaire2= new Beneficiaire("VIVAQUA","Public");
    List<Beneficiaire>beneficiaireList=List.of(beneficiaire1,beneficiaire2);

//endregion

//   region Etiquette
    Etiquette etiquette1=new Etiquette("Dépense ménagère");
    Etiquette etiquette2=new Etiquette("Produit");
    Etiquette etiquette3=new Etiquette("Charge Fixe");
    Etiquette etiquette4=new Etiquette("Amazon");
    List<Etiquette>etiquetteList=List.of(etiquette1,etiquette2,etiquette3,etiquette4);


//    endregion


    @Override
    public void afterPropertiesSet() throws Exception {
        utilisateurRepository.saveAll(utilisateurList);
        accountUserRepository.saveAll(accountUserList);
        beneficiaireRepository.saveAll(beneficiaireList);
        etiquetteRepository.saveAll(etiquetteList);
    }
}
