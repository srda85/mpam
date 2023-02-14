package com.srda.mpam.service.accountUser;

import com.srda.mpam.exceptions.UtilisateurIntrouvableException;
import com.srda.mpam.mapper.AccountUserMapper;
import com.srda.mpam.model.dto.AccountUserDTO;
import com.srda.mpam.model.entity.AccountUser;
import com.srda.mpam.model.form.accountUserForm.AccountUserForm;
import com.srda.mpam.model.form.accountUserForm.AccountUserUpdateForm;
import com.srda.mpam.repositories.AccountUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountUserServiceImp implements AccountUserService{

    @Autowired
    AccountUserRepository accountUserRepository;

    @Autowired
    AccountUserMapper accountUserMapper;

    @Override
    public List<AccountUserDTO> getAll() {
    return accountUserRepository.findAll()
            .stream()
            .map(accountUserMapper::toDTO)
            .toList();
    }


    @Override
    public AccountUserDTO create(AccountUserForm toInsert) {
        return accountUserMapper.toDTO(accountUserRepository.save(accountUserMapper.toEntity((toInsert))));
    }

    @Override
    public AccountUserDTO update(Long id, AccountUserUpdateForm toUpdate) {
        if (toUpdate == null || id == null)throw new IllegalArgumentException("toUpdate can't be null");
        AccountUser accountUser=accountUserMapper.toEntityUpdate(toUpdate);

        if(accountUserRepository.findById(id).isEmpty())throw new UtilisateurIntrouvableException("Id account not found");
        accountUser.setId(id);
        accountUserRepository.saveAndFlush(accountUser);
        return accountUserMapper.toDTO(accountUser);
    }

    //Créer exception personnalisée
    @Override
    public AccountUserDTO getOne(Long id) {
        return accountUserMapper.toDTO(accountUserRepository.findById(id).orElseThrow(()->new RuntimeException("not found")));
    }

    @Override
    public void delete(Long id) {
        AccountUser accountUser = accountUserRepository.findById(id).orElseThrow(()->new RuntimeException("not found"));
        accountUserRepository.delete(accountUser);

    }
}
