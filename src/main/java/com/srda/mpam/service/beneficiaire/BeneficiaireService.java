package com.srda.mpam.service.beneficiaire;


import com.srda.mpam.model.dto.BeneficiaireDTO;
import com.srda.mpam.model.form.beneficiaire.BeneficiaireForm;
import com.srda.mpam.model.form.beneficiaire.BeneficiaireUpdateForm;
import com.srda.mpam.service.CrudService;

public interface BeneficiaireService extends CrudService<BeneficiaireDTO,Long, BeneficiaireForm, BeneficiaireUpdateForm> {

}
