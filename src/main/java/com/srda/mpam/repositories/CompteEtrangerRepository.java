package com.srda.mpam.repositories;

import com.srda.mpam.model.entity.CompteEtranger;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompteEtrangerRepository extends JpaRepository<CompteEtranger, Long> {

    public CompteEtranger findCompteEtrangerByDenominationOfficielle(String denomination);

    public Boolean existsCompteEtrangerByDenominationOfficielle(String denomination);
}
