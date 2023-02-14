package com.srda.mpam.mapper;

import com.srda.mpam.model.dto.AccountUserDTO;
import com.srda.mpam.model.entity.AccountUser;
import com.srda.mpam.model.form.accountUserForm.AccountUserForm;
import com.srda.mpam.model.form.accountUserForm.AccountUserUpdateForm;
import com.srda.mpam.repositories.AccountUserRepository;
import com.srda.mpam.repositories.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AccountUserMapper {

    @Autowired
    AccountUserRepository accountUserRepository;

    @Autowired
    UtilisateurRepository utilisateurRepository;

    public AccountUserDTO toDTO(AccountUser accountUser) {
        return AccountUserDTO.builder()
                .id(accountUser.getId())
                .accountNumber(accountUser.getAccountNumber())
                .solde(accountUser.getSolde())
                .userId(accountUser.getUtilisateur().getId())
                .build();
    }

    public AccountUser toEntity(AccountUserForm accountUserForm){
        return new AccountUser(
                utilisateurRepository.findById(
                        accountUserForm.getUserId()).orElseThrow(()->new RuntimeException("pas trouvé")),
                accountUserForm.getAccountNumber(),
                accountUserForm.getSolde()
        );
    }

    public AccountUser toEntityUpdate(AccountUserUpdateForm accountUserUpdateForm){
        return new AccountUser(
                utilisateurRepository.findById(
                        accountUserUpdateForm.getUserId()).orElseThrow(()->new RuntimeException("user not found")),
                accountUserUpdateForm.getAccountNumber(),
                accountUserUpdateForm.getSolde()
        );
    }
}


