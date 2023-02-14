package com.srda.mpam.service.accountUser;

import com.srda.mpam.model.dto.AccountUserDTO;
import com.srda.mpam.model.form.accountUserForm.AccountUserForm;
import com.srda.mpam.model.form.accountUserForm.AccountUserUpdateForm;
import com.srda.mpam.service.CrudService;

public interface AccountUserService extends CrudService<AccountUserDTO,Long, AccountUserForm, AccountUserUpdateForm> {
}
