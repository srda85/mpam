package com.srda.mpam.mapper;

import com.srda.mpam.model.dto.OperationDto;
import com.srda.mpam.model.entity.Operation;
import com.srda.mpam.model.form.operation.OperationForm;
import com.srda.mpam.model.form.operation.OperationFormUpdate;
import com.srda.mpam.repositories.AccountUserRepository;
import com.srda.mpam.repositories.CompteEtrangerRepository;
import com.srda.mpam.repositories.OperationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class OperationMapper {

    @Autowired
    OperationRepository operationRepository;

    @Autowired
    AccountUserRepository accountUserRepository;

    @Autowired
    CompteEtrangerRepository compteEtrangerRepository;


    public OperationDto toDto(Operation operation){
        return OperationDto.builder()
                .id(operation.getId())
                .dateValeur(operation.getDateValeur())
                .montant(operation.getMontant())
                .refBanquaire(operation.getRefBanquaire())
                .accountUserId(operation.getAccountUser().getId())
                .compteEtrangerId(operation.getCompteEtranger().getId())
                .build();
    }

    public Operation toEntity(OperationForm operationForm){
        return new Operation(
                operationForm.getMontant(),
                operationForm.getDateValeur(),
                operationForm.getRefBanquaire(),
                accountUserRepository.findById(operationForm.getAccountUserId()).orElseThrow(()->new RuntimeException("Account user id not found")),
                compteEtrangerRepository.findById(operationForm.getCompteEtrangerId()).orElseThrow(()->new RuntimeException("Compte Etranger not found"))
        );
    }
    public Operation toEntityUpdate(OperationFormUpdate operationFormUpdate){
        return new Operation(
                operationFormUpdate.getMontant(),
                operationFormUpdate.getDateValeur(),
                operationFormUpdate.getRefBanquaire(),
                accountUserRepository.findById(operationFormUpdate.getAccountUserId()).orElseThrow(()->new RuntimeException("Account user id not found")),
                compteEtrangerRepository.findById(operationFormUpdate.getCompteEtrangerId()).orElseThrow(()->new RuntimeException("Compte Etranger not found"))
        );
    }




}
