package com.srda.mpam.model.form.pdf;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
//Pas sûr qu'il faille garder cette classe. Je la créée pour récupèrer le string que je vais envoyer dans une requête.
public class PdfForm {

    private String path;

}
