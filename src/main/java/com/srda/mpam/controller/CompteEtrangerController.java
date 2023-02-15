package com.srda.mpam.controller;

import com.srda.mpam.model.dto.CompteEtrangerDTO;
import com.srda.mpam.model.form.compteEtranger.CompteEtrangerForm;
import com.srda.mpam.model.form.compteEtranger.CompteEtrangerFormUpdate;
import com.srda.mpam.service.compteEtranger.CompteEtrangerServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/compteEtranger")
public class CompteEtrangerController {

    @Autowired
    CompteEtrangerServiceImp compteEtrangerServiceImp;

    @GetMapping("/all")
    public List<CompteEtrangerDTO> getAll(){
        return compteEtrangerServiceImp.getAll();
    }

    @GetMapping(value = "{id}")
    public CompteEtrangerDTO getOne(@PathVariable Long id){
        return compteEtrangerServiceImp.getOne(id);
    }

    @PostMapping
    public CompteEtrangerDTO create(@RequestBody CompteEtrangerForm compteEtrangerForm){
        return compteEtrangerServiceImp.create(compteEtrangerForm);
    }

    @DeleteMapping(value = "{id}")
    public void delete(@PathVariable Long id){
         compteEtrangerServiceImp.delete(id);
    }

    @PutMapping(value = "{id}")
    public CompteEtrangerDTO update(@PathVariable Long id, @RequestBody CompteEtrangerFormUpdate compteEtrangerFormUpdate){
        return compteEtrangerServiceImp.update(id,compteEtrangerFormUpdate);
    }
}
