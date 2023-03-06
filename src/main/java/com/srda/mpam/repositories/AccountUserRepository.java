package com.srda.mpam.repositories;

import com.srda.mpam.model.entity.AccountUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountUserRepository extends JpaRepository<AccountUser, Long> {

    //Création d'une méthode qui va me récupèrer l'entité par le numéro de compte
    public  AccountUser findAccountUserByAccountNumber(String accountNumber);
}
