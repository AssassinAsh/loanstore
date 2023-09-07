package com.loanstore.repositories.slave;

import com.loanstore.entities.LoansEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface LoanSlaveRepo extends JpaRepository<LoansEntity, Long> {

    List<LoansEntity> findByDueDateBefore(Date currentDate);
}
