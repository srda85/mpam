package com.srda.mpam.service.etiquette;

import com.srda.mpam.model.dto.EtiquetteDTO;
import com.srda.mpam.model.form.etiquette.EtiquetteForm;
import com.srda.mpam.model.form.etiquette.EtiquetteFormUpdate;
import com.srda.mpam.service.CrudService;

public interface EtiquetteService extends CrudService<EtiquetteDTO,Long, EtiquetteForm, EtiquetteFormUpdate> {
}
