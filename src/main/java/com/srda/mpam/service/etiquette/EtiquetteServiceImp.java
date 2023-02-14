package com.srda.mpam.service.etiquette;

import com.srda.mpam.mapper.EtiquetteMapper;
import com.srda.mpam.model.dto.EtiquetteDTO;
import com.srda.mpam.model.entity.Etiquette;
import com.srda.mpam.model.form.etiquette.EtiquetteForm;
import com.srda.mpam.model.form.etiquette.EtiquetteFormUpdate;
import com.srda.mpam.repositories.EtiquetteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EtiquetteServiceImp implements EtiquetteService {

    @Autowired
    EtiquetteRepository etiquetteRepository;
    @Autowired
    EtiquetteMapper etiquetteMapper;

    @Override
    public List<EtiquetteDTO> getAll() {
        return etiquetteRepository.findAll().stream().map(etiquetteMapper::toDto).toList();
    }

    @Override
    public EtiquetteDTO getOne(Long id) {
        return etiquetteMapper.toDto(etiquetteRepository.findById(id).orElseThrow(()->new RuntimeException("not found")));
    }

    @Override
    public EtiquetteDTO create(EtiquetteForm toInsert) {
        return etiquetteMapper.toDto(etiquetteRepository.save(etiquetteMapper.toEntity(toInsert)));
    }

    @Override
    public void delete(Long id) {
        Etiquette etiquette=etiquetteRepository.findById(id).orElseThrow(()->new RuntimeException("not Found"));
        etiquetteRepository.delete(etiquette);
    }

    @Override
    public EtiquetteDTO update(Long id, EtiquetteFormUpdate toUpdate) {
        if (toUpdate == null || id == null)throw new IllegalArgumentException("toUpdate can't be null");
        Etiquette etiquette=etiquetteMapper.toEntityUpdate(toUpdate);
        if (!etiquetteRepository.existsById(id))throw new RuntimeException("Id not valid");
        etiquette.setId(id);
        etiquetteRepository.saveAndFlush(etiquette);

        return etiquetteMapper.toDto(etiquette);
    }



}
