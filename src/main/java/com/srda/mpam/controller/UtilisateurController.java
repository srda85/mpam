package com.srda.mpam.controller;

import com.srda.mpam.model.dto.UtilisateurDTO;
import com.srda.mpam.model.entity.Utilisateur;
import com.srda.mpam.model.form.UtilisateurForm;
import com.srda.mpam.service.utilisateur.UtilisateurServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//Combinaison de @Controller et @ResponseBody
@RestController
@RequestMapping("/utilisateur")
public class UtilisateurController {


    @Autowired
    UtilisateurServiceImp utilisateurServiceImp;

    @GetMapping("/all")
    public List<UtilisateurDTO> getAll(){
        return utilisateurServiceImp.getAll();
    }

    @GetMapping(value ="{id}")
    public UtilisateurDTO getById(@PathVariable Long id){
        return utilisateurServiceImp.getOne(id);
    }

    @PostMapping()
    public UtilisateurDTO create(@RequestBody UtilisateurForm utilisateurForm){
        return utilisateurServiceImp.create(utilisateurForm);
    }

    @DeleteMapping(value = "{id}")
    public void deleteById(@PathVariable Long id){
        utilisateurServiceImp.delete(id);
    }

}
