package com.srda.mpam.service.operation;

import com.srda.mpam.mapper.OperationMapper;
import com.srda.mpam.model.dto.OperationDto;
import com.srda.mpam.model.entity.Operation;
import com.srda.mpam.model.form.operation.OperationForm;
import com.srda.mpam.model.form.operation.OperationFormUpdate;
import com.srda.mpam.repositories.OperationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OperationServiceImp implements OperationService{


    @Autowired
    OperationRepository operationRepository;

    @Autowired
    OperationMapper operationMapper;

    @Override
    public List<OperationDto> getAll() {
        return operationRepository.findAll().stream().map(operationMapper::toDto).toList();
    }

    @Override
    public OperationDto getOne(Long id) {
        return operationMapper.toDto(operationRepository.findById(id).orElseThrow(()->new RuntimeException("not found")));
    }

    @Override
    public OperationDto create(OperationForm toInsert) {
        return operationMapper.toDto(operationRepository.save(operationMapper.toEntity(toInsert)));
    }

    @Override
    public OperationDto update(Long id, OperationFormUpdate toUpdate) {
        if (toUpdate == null || id == null)throw new IllegalArgumentException("toUpdate can't be null");
        Operation operation=operationMapper.toEntityUpdate(toUpdate);
        if (!operationRepository.existsById(id))throw new RuntimeException("Id not valid");
        operation.setId(id);
        operationRepository.saveAndFlush(operation);
        return operationMapper.toDto(operation);
    }


    @Override
    public void delete(Long id) {
        Operation operation=operationRepository.findById(id).orElseThrow(()->new RuntimeException("not found"));
        operationRepository.delete(operation);
    }
}
