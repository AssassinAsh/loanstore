package com.loanstore.repositories.master;

import com.loanstore.entities.LenderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LenderMasterRepo extends JpaRepository<LenderEntity, Integer> {
}
