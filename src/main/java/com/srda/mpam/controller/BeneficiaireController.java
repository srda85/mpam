package com.srda.mpam.controller;

import com.srda.mpam.model.dto.BeneficiaireDTO;
import com.srda.mpam.model.form.beneficiaire.BeneficiaireForm;
import com.srda.mpam.model.form.beneficiaire.BeneficiaireUpdateForm;
import com.srda.mpam.service.beneficiaire.BeneficiaireServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/beneficiaire")
public class BeneficiaireController {

    @Autowired
    BeneficiaireServiceImp beneficiaireServiceImp;


    @GetMapping("/all")
    public List<BeneficiaireDTO> getAll (){
        return beneficiaireServiceImp.getAll();
    }

    @GetMapping(value = "{id}")
    public BeneficiaireDTO getOne(@PathVariable Long id){
        return beneficiaireServiceImp.getOne(id);
    }

    @PostMapping
    public BeneficiaireDTO create(@RequestBody BeneficiaireForm beneficiaireForm){
        return beneficiaireServiceImp.create(beneficiaireForm);
    }

    @DeleteMapping(value = "{id}")
    public void delete(@PathVariable Long id){
        beneficiaireServiceImp.delete(id);
    }

    @PutMapping(value = "{id}")
    public BeneficiaireDTO update(@PathVariable Long id, @RequestBody BeneficiaireUpdateForm updateForm){
        return beneficiaireServiceImp.update(id,updateForm);
    }



}
