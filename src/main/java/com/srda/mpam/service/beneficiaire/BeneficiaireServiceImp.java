package com.srda.mpam.service.beneficiaire;

import com.srda.mpam.mapper.BeneficiaireMapper;
import com.srda.mpam.model.dto.BeneficiaireDTO;
import com.srda.mpam.model.entity.Beneficiaire;
import com.srda.mpam.model.form.beneficiaire.BeneficiaireForm;
import com.srda.mpam.model.form.beneficiaire.BeneficiaireUpdateForm;
import com.srda.mpam.repositories.BeneficiaireRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class BeneficiaireServiceImp implements BeneficiaireService{


    @Autowired
    BeneficiaireMapper beneficiaireMapper;

    @Autowired
    BeneficiaireRepository beneficiaireRepository;

    @Override
    public List<BeneficiaireDTO> getAll() {
        return beneficiaireRepository.findAll().stream().map(beneficiaireMapper::toDto).toList();
    }

    @Override
    public BeneficiaireDTO getOne(Long id) {
        return beneficiaireMapper.toDto(beneficiaireRepository.findById(id).orElseThrow(()->new RuntimeException("not found")));
    }


    @Override
    public BeneficiaireDTO create(BeneficiaireForm toInsert) {
        return beneficiaireMapper.toDto(beneficiaireRepository.save(beneficiaireMapper.toEntity(toInsert)));
    }

//    Pour info j'ai décidé de changer la méthode de suppression qui ne renvoie désormais plus un DTO
    @Override
    public void delete(Long id) {
       Beneficiaire beneficiaire = beneficiaireRepository.findById(id).orElseThrow(()->new RuntimeException("not found"));
       beneficiaireRepository.delete(beneficiaire);
    }

    @Override
    public BeneficiaireDTO update(Long id, BeneficiaireUpdateForm toUpdate) {
        if (toUpdate == null || id == null)throw new IllegalArgumentException("toUpdate can't be null");
        Beneficiaire beneficiaire = beneficiaireMapper.toEntityUpdate(toUpdate);
        if (!beneficiaireRepository.existsById(id))throw new RuntimeException("Id not valid");
        beneficiaire.setId(id);
        beneficiaireRepository.saveAndFlush(beneficiaire);
        return beneficiaireMapper.toDto(beneficiaire);
    }






}
