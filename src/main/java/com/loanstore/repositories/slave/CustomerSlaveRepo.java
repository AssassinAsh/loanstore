package com.loanstore.repositories.slave;

import com.loanstore.entities.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerSlaveRepo extends JpaRepository<CustomerEntity, Integer> {

    CustomerEntity findByCustomerId(Integer customerId);
}
