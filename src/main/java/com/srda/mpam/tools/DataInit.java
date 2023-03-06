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
    private final EtiquetteRepository etiquetteRepository;
    private final CompteEtrangerRepository compteEtrangerRepository;
    private final OperationRepository operationRepository;

    public DataInit(UtilisateurRepository utilisateurRepository, AccountUserRepository accountUserRepository, EtiquetteRepository etiquetteRepository, CompteEtrangerRepository compteEtrangerRepository, OperationRepository operationRepository) {
        this.utilisateurRepository=utilisateurRepository;
        this.accountUserRepository = accountUserRepository;
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
    AccountUser accountUser1=new AccountUser(utilisateur1,"BE73 2100 2726 7560",0L);
    AccountUser accountUser2=new AccountUser(utilisateur1,"123-941634-48",150L);

    private final List<AccountUser>accountUserList=List.of(accountUser1,accountUser2);
//endregion




//    region CompteEtranger

    CompteEtranger compteEtranger1=new CompteEtranger("BE32-8100-2726-8460","Vivaqua SPRL","Vivaqua","Public");
    CompteEtranger compteEtranger2=new CompteEtranger("BE32-8100-2726-8460","Eleonora Stanciu","Eleonora","Privé");
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
//    Operation operation1=new Operation(100L, LocalDate.of(2032,1,5),1L,accountUser1,compteEtranger1);
//    Operation operation2=new Operation(200L, LocalDate.now(),2L,accountUser1,compteEtranger2);
//    List<Operation>operationList=List.of(operation1,operation2);
////    endregion
//
//
//
//    @Override
    public void afterPropertiesSet() throws Exception {
        utilisateurRepository.saveAll(utilisateurList);
        accountUserRepository.saveAll(accountUserList);
        etiquetteRepository.saveAll(etiquetteList);
        compteEtrangerRepository.saveAll(compteEtrangerList);
//        operationRepository.saveAll(operationList);
    }
}
