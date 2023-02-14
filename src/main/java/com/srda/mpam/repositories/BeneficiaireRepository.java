package com.srda.mpam.repositories;

import com.srda.mpam.model.entity.Beneficiaire;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BeneficiaireRepository extends JpaRepository<Beneficiaire,Long> {
}
