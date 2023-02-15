package com.srda.mpam.service.compteEtranger;

import com.srda.mpam.model.dto.CompteEtrangerDTO;
import com.srda.mpam.model.form.compteEtranger.CompteEtrangerForm;
import com.srda.mpam.model.form.compteEtranger.CompteEtrangerFormUpdate;
import com.srda.mpam.service.CrudService;

public interface CompteEtrangerService extends CrudService<CompteEtrangerDTO, Long, CompteEtrangerForm, CompteEtrangerFormUpdate> {
}
