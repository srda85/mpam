package com.srda.mpam.repositories;


import com.srda.mpam.model.entity.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UtilisateurRepository extends JpaRepository<Utilisateur,Long> {
}
