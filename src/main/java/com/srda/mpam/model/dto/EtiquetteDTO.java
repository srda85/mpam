package com.srda.mpam.model.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class EtiquetteDTO {

    private Long id;
    private String nom;
}
