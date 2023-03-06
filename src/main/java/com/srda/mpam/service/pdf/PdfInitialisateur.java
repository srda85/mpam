package com.srda.mpam.service.pdf;


import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.io.File;
import java.io.IOException;

public class PdfInitialisateur {

    protected static String getStringPdf(String path) {
        //Pas oublier l'extension
//        String path = "D:\\test.pdf";

        //Représentation abstraite du fichier et sérialisation
        if (path.contains(".pdf")) {
            File file = new File(path);
            try {
                //Il s'agit de la représentation en mémoire du document PDF.
                PDDocument inputPdf = PDDocument.load(file);
                PDFTextStripper pdfTextStripper = new PDFTextStripper();
                String textPdf = pdfTextStripper.getText(inputPdf);
                return textPdf;
            } catch (IOException ioException) {
                System.out.println(ioException.getMessage());
            }
            //        This class will take a pdf document and strip out all of the text and ignore the formatting and such
        }else throw new RuntimeException("pdf introuvable");
        return null;
    }
}