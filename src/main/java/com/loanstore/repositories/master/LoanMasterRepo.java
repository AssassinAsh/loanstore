package com.loanstore.repositories.master;

import com.loanstore.entities.LoansEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoanMasterRepo extends JpaRepository<LoansEntity, Long> {
}
