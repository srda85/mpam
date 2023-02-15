package com.srda.mpam.service.compteEtranger;

import com.srda.mpam.mapper.CompteEtrangerMapper;
import com.srda.mpam.model.dto.CompteEtrangerDTO;
import com.srda.mpam.model.entity.CompteEtranger;
import com.srda.mpam.model.form.compteEtranger.CompteEtrangerForm;
import com.srda.mpam.model.form.compteEtranger.CompteEtrangerFormUpdate;
import com.srda.mpam.repositories.CompteEtrangerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompteEtrangerServiceImp implements CompteEtrangerService {

    @Autowired
    CompteEtrangerRepository compteEtrangerRepository;

    @Autowired
    CompteEtrangerMapper compteEtrangerMapper;


    @Override
    public List<CompteEtrangerDTO> getAll() {
        return compteEtrangerRepository.findAll().stream().map(compteEtrangerMapper::toDto).toList();
    }

    @Override
    public CompteEtrangerDTO getOne(Long id) {
        return compteEtrangerMapper.toDto(
                compteEtrangerRepository.findById(id).orElseThrow(()->new RuntimeException("not found"))
        );
    }

    @Override
    public CompteEtrangerDTO create(CompteEtrangerForm toInsert) {
        return compteEtrangerMapper.toDto(
                compteEtrangerRepository.save(compteEtrangerMapper.toEntity(toInsert))
        );
    }

    @Override
    public CompteEtrangerDTO update(Long id, CompteEtrangerFormUpdate toUpdate) {
        if (toUpdate == null || id == null)throw new IllegalArgumentException("toUpdate can't be null");
        CompteEtranger compteEtranger=compteEtrangerMapper.toEntityUpdate(toUpdate);
        if (!compteEtrangerRepository.existsById(id))throw new RuntimeException("Id not valid");
        compteEtranger.setId(id);
        compteEtrangerRepository.saveAndFlush(compteEtranger);
        return compteEtrangerMapper.toDto(compteEtranger);
    }



    @Override
    public void delete(Long id) {
        CompteEtranger compteEtranger=compteEtrangerRepository.findById(id).orElseThrow(()->new RuntimeException("not found"));
        compteEtrangerRepository.delete(compteEtranger);
    }
}
