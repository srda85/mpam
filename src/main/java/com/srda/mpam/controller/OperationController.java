package com.srda.mpam.controller;

import com.srda.mpam.model.dto.OperationDto;
import com.srda.mpam.model.entity.Operation;
import com.srda.mpam.model.form.operation.OperationForm;
import com.srda.mpam.model.form.operation.OperationFormUpdate;
import com.srda.mpam.service.operation.OperationService;
import com.srda.mpam.service.operation.OperationServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/operation")
public class OperationController {


    @Autowired
    OperationServiceImp operationServiceImp;

    @GetMapping("/all")
    public List<OperationDto>getAll(){
        return operationServiceImp.getAll();
    }


    @GetMapping(value = "{id}")
    public OperationDto getOne(@PathVariable Long id){
        return operationServiceImp.getOne(id);
    }

    @PostMapping
    public OperationDto create(@RequestBody OperationForm operationForm){
        return operationServiceImp.create(operationForm);
    }

    @DeleteMapping(value = "{id}")
    public void delete(@PathVariable Long id){
        operationServiceImp.delete(id);
    }


    @PutMapping(value = "{id}")
    public OperationDto update(@RequestBody OperationFormUpdate operationFormUpdate,@PathVariable Long id){
        return operationServiceImp.update(id,operationFormUpdate);
    }







}
