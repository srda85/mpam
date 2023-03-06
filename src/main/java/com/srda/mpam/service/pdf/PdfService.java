package com.srda.mpam.service.pdf;

import com.srda.mpam.model.entity.AccountUser;
import com.srda.mpam.model.entity.CompteEtranger;
import com.srda.mpam.model.entity.Operation;
import com.srda.mpam.model.form.pdf.PdfForm;
import com.srda.mpam.repositories.AccountUserRepository;
import com.srda.mpam.repositories.CompteEtrangerRepository;
import com.srda.mpam.repositories.OperationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class PdfService {

//    @Autowired
//    PdfInitialisateur pdfInitialisateur;


    @Autowired
    AccountUserRepository accountUserRepository;

    @Autowired
    CompteEtrangerRepository compteEtrangerRepository;

    @Autowired
    OperationRepository operationRepository;

    public void generateAllTransactionsWithPdf(String path)  {
        String pdfEnString=PdfInitialisateur.getStringPdf(path);
        //je récupère la liste de tous les indexes des parties comprenant les mots clés
        List<Integer>indexLists=PdfAlgo.indexesGenerateur(pdfEnString);
        //je mets les transaction dans une liste grace aux indexes
        ArrayList<String>transactionsList=PdfAlgo.separateAllTransactions(pdfEnString,indexLists);
        String datePdf=PdfAlgo.recuperationDateAcAnnee(pdfEnString);
        String numeroDeCompte=PdfAlgo.getNumeroDeCompte(pdfEnString);

        //Récupération de l'entité compte de l'utilisateur pour pouvoir l'associer à la transaction créée.
        AccountUser accountUser=accountUserRepository.findAccountUserByAccountNumber(numeroDeCompte);
        if (accountUser==null)throw new RuntimeException("Account number not found in DB");
        CompteEtranger compteEtranger;
        Operation operation;
        String dateTransaction;
        for (int i=0; i<transactionsList.size();i++){
            String denominationOfficielleCompteEtranger=PdfAlgo.contrepartieTransaction(transactionsList.get(i));
            //si le compte étranger existe je le récupère
            if (compteEtrangerRepository.existsCompteEtrangerByDenominationOfficielle(denominationOfficielleCompteEtranger)){
                compteEtranger=compteEtrangerRepository.findCompteEtrangerByDenominationOfficielle(denominationOfficielleCompteEtranger);
            }else {
                compteEtranger=new CompteEtranger(denominationOfficielleCompteEtranger);
                compteEtrangerRepository.save(compteEtranger);
            }
            dateTransaction=PdfAlgo.dateTransaction(transactionsList.get(i));

            operation=new Operation(
                    PdfAlgo.montantTransaction(transactionsList.get(i)),
                    PdfAlgo.dateParserTransaction(datePdf,dateTransaction),
                    PdfAlgo.numeroTransaction(transactionsList.get(i)),
                    accountUser,
                    compteEtranger
            );
            operationRepository.save(operation);


        }


    }
}
