package com.srda.mpam.service.operation;

import com.srda.mpam.model.dto.OperationDto;
import com.srda.mpam.model.form.operation.OperationForm;
import com.srda.mpam.model.form.operation.OperationFormUpdate;
import com.srda.mpam.service.CrudService;

public interface OperationService extends CrudService<OperationDto,Long, OperationForm, OperationFormUpdate> {
}
