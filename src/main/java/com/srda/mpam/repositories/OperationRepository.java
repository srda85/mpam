package com.srda.mpam.repositories;


import com.srda.mpam.model.entity.Operation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OperationRepository extends JpaRepository<Operation,Long> {
}
