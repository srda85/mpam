package com.srda.mpam.controller;

import com.srda.mpam.model.dto.EtiquetteDTO;
import com.srda.mpam.model.form.etiquette.EtiquetteForm;
import com.srda.mpam.model.form.etiquette.EtiquetteFormUpdate;
import com.srda.mpam.repositories.EtiquetteRepository;
import com.srda.mpam.service.etiquette.EtiquetteServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/etiquette")
public class EtiquetteController {

    @Autowired
    EtiquetteServiceImp etiquetteServiceImp;


    @GetMapping("/all")
    public List<EtiquetteDTO> getAll(){
        return etiquetteServiceImp.getAll();
    }

    @GetMapping(value = "{id}")
    public EtiquetteDTO getOne(@PathVariable Long id){
        return etiquetteServiceImp.getOne(id);
    }

    @PostMapping
    public EtiquetteDTO create(@RequestBody EtiquetteForm etiquetteForm){
        return etiquetteServiceImp.create(etiquetteForm);
    }

    @DeleteMapping(value = "{id}")
    public void delete(@PathVariable Long id){
        etiquetteServiceImp.delete(id);
    }

    @PutMapping(value = "{id}")
    public EtiquetteDTO update(@PathVariable Long id, @RequestBody EtiquetteFormUpdate etiquetteFormUpdate){
        return etiquetteServiceImp.update(id,etiquetteFormUpdate);
    }

}
