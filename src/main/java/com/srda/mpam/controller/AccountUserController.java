package com.srda.mpam.controller;

import com.srda.mpam.model.dto.AccountUserDTO;
import com.srda.mpam.model.form.accountUserForm.AccountUserForm;
import com.srda.mpam.model.form.accountUserForm.AccountUserUpdateForm;
import com.srda.mpam.service.accountUser.AccountUserServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/accountUser")
public class AccountUserController {

    @Autowired
    AccountUserServiceImp accountUserServiceImp;

    @GetMapping("/all")
    public List<AccountUserDTO> getAll(){
        return accountUserServiceImp.getAll();
    }


    @GetMapping(value = "{id}")
    public AccountUserDTO getOne(@PathVariable Long id){
        return accountUserServiceImp.getOne(id);
    }

    @PostMapping
    public AccountUserDTO create(@RequestBody AccountUserForm accountUserForm){
        return accountUserServiceImp.create(accountUserForm);
    }

    @PutMapping(value = "{id}")
    public AccountUserDTO update(@RequestBody AccountUserUpdateForm accountUserUpdateForm, @PathVariable Long id){
        return accountUserServiceImp.update(id, accountUserUpdateForm);
    }

    @DeleteMapping(value = "{id}")
    public void delete(@PathVariable Long id){
        accountUserServiceImp.delete(id);
    }






}
