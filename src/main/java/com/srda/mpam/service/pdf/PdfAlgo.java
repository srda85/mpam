package com.srda.mpam.service.pdf;

import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class PdfAlgo {

    protected static List<Integer> indexesGenerateur(String textPdf){
        List<String>listMotClePdf=List.of("Paiement","Virement", "Redevance");
        boolean findWord=true;
        List<Integer>indexList=new ArrayList<>();
        int index=0;
        //l'indexDiminue va me permettre de récupèrer aussi le numéro de la transaction qui est -7 ou -22 en index selon le mot
        int indexDiminue=7;
        for (int i=0; i<listMotClePdf.size();i++){
            String motCle=listMotClePdf.get(i);
            //si le mot est Redevance, l'index diminue doit être plus grand
            if (i==2)indexDiminue=22;
            //faut remettre l'index à zero lorsqu'on augmente i de 1.
            index=0;
            while (index!=-1) {
                index = textPdf.indexOf(motCle, index);
                if (index != -1) {
//                    System.out.println(index);
                    //je mets l'index de début dans une liste
                    indexList.add(index - indexDiminue);
                    //J'ai juste besoin d'augmenter l'index de 1 pour qu'il repère le mot clé suivant dans le String
                    index++;
                }
            }
        }
        return indexList;
    }

    protected static ArrayList<String> separateAllTransactions(String textPdf, List<Integer>transactionsIndexesList){
        //Je créé un string qui va récupérer chaque partie du pdf selon les différents mots clés
        String transaction;
        //Je créé une liste qui va acceuillir tous ces strings.
        ArrayList<String>transactionStringList=new ArrayList<>();
        //Je créé une boucle qui va iterer eb fonction de la liste qui a récupèré tous les index (DOIT FAIRE IF NULL)
        for (int i=0;i<transactionsIndexesList.size();i++) {
            //Je récupère l'index du premier 'à la ligne, espace' qui se situe après le premier index de ma liste
            int indexOfNewLineSpace = textPdf.indexOf("\n\s", transactionsIndexesList.get(i));
            //Je vérifie si cet index existe ou pas (-1) et si ce n'est pas le cas je prends la fin du string comme référence, sinon je prends celui que j'ai récupèré
            if (indexOfNewLineSpace == -1) {
                transaction = textPdf.substring(transactionsIndexesList.get(i), textPdf.length() - 1);
            } else {
                transaction = textPdf.substring(transactionsIndexesList.get(i), indexOfNewLineSpace);
            }
            transactionStringList.add(transaction);
        }return transactionStringList;
    }

    //Faudra une méthode pour récupèrer le numéro de carte car il me sert de référence....  ou je dois essayer avec un pattern
    protected static String contrepartieTransaction(String transaction){
        if (transaction.contains("Redevance mensuelle"))return "Fortis";
            //Faudra permettre d'intégréer manuellement le numéro de compte et de faire une conversion
        else if (transaction.contains("Paiement")) {
            int indexNumCompte=transaction.indexOf("4871 04XX XXXX 2234");
            int indexRetourLigne1=transaction.indexOf("\n", indexNumCompte);
            int indexRetourLigne2=transaction.indexOf("\n", indexRetourLigne1+1);
            String ligneNomContrepartie=transaction.substring(indexRetourLigne1,indexRetourLigne2);
//        Pattern qui regroupe deux possibilités à cause d'un nom de lieu comprenant potentiellement un tiret.
            Pattern patternDateLieu=Pattern.compile("\\s\\w+-\\w+\\s\\d\\d-\\d\\d-\\d\\d\\d\\d|\\w+\\s\\d\\d-\\d\\d-\\d\\d\\d\\d");
            Matcher matcherDateLieu=patternDateLieu.matcher(ligneNomContrepartie);
            if (matcherDateLieu.find()) ligneNomContrepartie =ligneNomContrepartie.replace(matcherDateLieu.group(),"");
//            System.out.println(ligneNomContrepartie);
            return ligneNomContrepartie;
        } else if (transaction.contains("Virement")) {
            Pattern patternRefBqMajuscule=Pattern.compile("\\d\\d \\d\\d\\d\\d \\d\\d\\d\\d \\d\\d\\d\\d");
            Matcher matcherRefBqMajuscule=patternRefBqMajuscule.matcher(transaction);
            String substringRef;
            if (matcherRefBqMajuscule.find()){
                substringRef=matcherRefBqMajuscule.group();
                int indexDebutCompteBq=transaction.indexOf(substringRef);
                int indexRetourLigneCompteBq=transaction.indexOf("\n",indexDebutCompteBq+1);
                int indexRetourLigneRefBq=transaction.indexOf("\n",indexRetourLigneCompteBq+1);
                int indexRetourLigneNomContrePartie=transaction.indexOf("\n",indexRetourLigneRefBq+1);
                String nomContrepartie=transaction.substring(indexRetourLigneRefBq,indexRetourLigneNomContrePartie);
                return nomContrepartie;
            }

        }return null;
    }

    protected static String getNumeroDeCompte(String textPdf){
        Pattern patternNumCompte=Pattern.compile("\\D\\D\\d\\d \\d\\d\\d\\d \\d\\d\\d\\d \\d\\d\\d\\d");
        Matcher matcherTextPdf= patternNumCompte.matcher(textPdf);
        if(matcherTextPdf.find()){
            return matcherTextPdf.group();
        }
        else throw new RuntimeException("numéro de compte pas trouvé");
    }

    protected static Double montantTransaction(String transaction){
        //Je créé deux patterns, l'un pour les nombres négatifs et l'autre pour les nombres positifs
        // le \\d+ veut dire autant de chiffre que possible qui se suivent
        Pattern patternMontantPositif=Pattern.compile("\\d+,\\d\\d\\+");
        Pattern patternMontantNegatif=Pattern.compile("\\d+,\\d\\d\\s-");
        Matcher matcherMontantPositif= patternMontantPositif.matcher(transaction);
        Matcher matcherMontantNegatif=patternMontantNegatif.matcher(transaction);
        String result = null;
        //Je dois utiliser des double pour les virgules.
        Double restultToReturn = null;
        if (matcherMontantPositif.find()){
            //je nettoie le string pour pouvoir le convertir
            result= matcherMontantPositif.group().replace("+","");

        } else if (matcherMontantNegatif.find()) {
            result=matcherMontantNegatif.group().replace(" -","");
            result=("-")+result;
        }
        if (result==null)throw new RuntimeException("aucun montant trouvé");
        //je dois remplacer la virgule par un point sinon il n'accepte pas la conversion.
        result=result.replace(",",".");
        restultToReturn=Double.parseDouble(result);
        return restultToReturn;
    }

    protected static String recuperationDateAcAnnee(String textPdf){
        Pattern patternDateAnnee=Pattern.compile("\\d\\d-\\d\\d-\\d\\d\\d\\d");
        Matcher matcherDateAnnee= patternDateAnnee.matcher(textPdf);
        String dateAnnee=null;
        if (matcherDateAnnee.find()){
            dateAnnee=matcherDateAnnee.group();
            return dateAnnee;
        }else throw new RuntimeException("date non trouvée");
    }

    protected static String dateTransaction(String transaction){
        Pattern patternDate =Pattern.compile("\\d\\d-\\d\\d\\s");
        Matcher matcher = patternDate.matcher(transaction);
        String date = null;
        if (matcher.find())date= matcher.group();
        return date;
    }

    protected static LocalDate dateParserTransaction(String datePdf, String dateTransaction){
        dateTransaction=dateTransaction.replace(" ","");
        datePdf=datePdf.replaceAll("\\d\\d-\\d\\d",dateTransaction);
        DateTimeFormatter dateTimeFormatter=DateTimeFormatter.ofPattern("d-MM-yyyy");
        LocalDate localDate=LocalDate.parse(datePdf, dateTimeFormatter);
        return localDate;
    }
    protected static Long numeroTransaction(String transaction){
        Pattern r=Pattern.compile("\\d\\d\\d\\d");
        Matcher matcher = r.matcher(transaction);
        String numeroTransaction="";
        if (matcher.find())numeroTransaction= matcher.group();
        return Long.parseLong(numeroTransaction);
    }



}
