package com.srda.mpam.model.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AccountUserDTO {

    private Long id;
    private String accountNumber;
    private Long solde;
    private Long userId;
}
