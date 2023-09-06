package com.loanstore.repositories.master;

import com.loanstore.entities.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerMasterRepo extends JpaRepository<CustomerEntity, Integer> {
}

