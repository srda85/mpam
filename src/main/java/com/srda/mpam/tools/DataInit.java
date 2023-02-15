package com.srda.mpam.tools;


import com.srda.mpam.model.entity.*;
import com.srda.mpam.repositories.*;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Service;


import java.time.LocalDate;
import java.util.List;

@Service
public class DataInit implements InitializingBean {

    private final UtilisateurRepository utilisateurRepository;
    private final AccountUserRepository accountUserRepository;
    private final BeneficiaireRepository beneficiaireRepository;
    private final EtiquetteRepository etiquetteRepository;
    private final CompteEtrangerRepository compteEtrangerRepository;
    private final OperationRepository operationRepository;

    public DataInit(UtilisateurRepository utilisateurRepository, AccountUserRepository accountUserRepository, BeneficiaireRepository beneficiaireRepository, EtiquetteRepository etiquetteRepository, CompteEtrangerRepository compteEtrangerRepository, OperationRepository operationRepository) {
        this.utilisateurRepository=utilisateurRepository;
        this.accountUserRepository = accountUserRepository;
        this.beneficiaireRepository = beneficiaireRepository;
        this.etiquetteRepository = etiquetteRepository;
        this.compteEtrangerRepository = compteEtrangerRepository;
        this.operationRepository = operationRepository;
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

    Beneficiaire beneficiaire3= new Beneficiaire("Amazon","Public");
    List<Beneficiaire>beneficiaireList=List.of(beneficiaire1,beneficiaire2, beneficiaire3);

//endregion


//    region CompteEtranger

    CompteEtranger compteEtranger1=new CompteEtranger("BE32-8100-2726-8460","Charges Fixes",beneficiaire2);
    CompteEtranger compteEtranger2=new CompteEtranger("BE32-8100-4518-8660","Amazon",beneficiaire3);
    List<CompteEtranger>compteEtrangerList=List.of(compteEtranger1,compteEtranger2);

//    endregion CompteEtranger

//   region Etiquette
    Etiquette etiquette1=new Etiquette("Dépense ménagère");
    Etiquette etiquette2=new Etiquette("Produit");
    Etiquette etiquette3=new Etiquette("Charge Fixe");
    Etiquette etiquette4=new Etiquette("Amazon");
    List<Etiquette>etiquetteList=List.of(etiquette1,etiquette2,etiquette3,etiquette4);


//    endregion

//    region Opération
    Operation operation1=new Operation(100L, LocalDate.of(2032,1,5),1L,accountUser1,compteEtranger1);
    Operation operation2=new Operation(200L, LocalDate.now(),2L,accountUser1,compteEtranger2);
    List<Operation>operationList=List.of(operation1,operation2);
//    endregion



    @Override
    public void afterPropertiesSet() throws Exception {
        utilisateurRepository.saveAll(utilisateurList);
        accountUserRepository.saveAll(accountUserList);
        beneficiaireRepository.saveAll(beneficiaireList);
        etiquetteRepository.saveAll(etiquetteList);
        compteEtrangerRepository.saveAll(compteEtrangerList);
        operationRepository.saveAll(operationList);
    }
}
