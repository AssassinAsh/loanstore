package com.loanstore.components;

import com.loanstore.entities.LoansEntity;
import com.loanstore.repositories.slave.LoanSlaveRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.Date;
import java.util.List;

@Configuration
@EnableScheduling
public class AlertComponent {

    private static final Logger LOGGER = LoggerFactory.getLogger(AlertComponent.class);

    @Autowired
    private LoanSlaveRepo loanSlaveRepo;

    /**
     * Scheduler Job - Runs every 10 seconds to retrieve all the loans than have exceeded their due dates.
     */
    @Scheduled(fixedDelay = 10 * 1000)
    public void retrieveLoansCrossingDueDate() {
        List<LoansEntity> loans = loanSlaveRepo.findByDueDateBefore(new Date());

        LOGGER.info("Total Loans exceeding due date: {}", loans.size());

        for (LoansEntity loan : loans) {
            LOGGER.info("Loan: {} exceeded its Due Date: {}", loan.getLoanId(), loan.getDueDate());
        }
    }
}
