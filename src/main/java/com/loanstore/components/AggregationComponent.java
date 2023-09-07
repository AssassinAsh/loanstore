package com.loanstore.components;

import com.loanstore.bos.LoansBo;
import com.loanstore.entities.CustomerEntity;
import com.loanstore.entities.LenderEntity;
import com.loanstore.repositories.master.CustomerMasterRepo;
import com.loanstore.repositories.master.LenderMasterRepo;
import com.loanstore.repositories.slave.CustomerSlaveRepo;
import com.loanstore.repositories.slave.LenderSlaveRepo;
import com.loanstore.utils.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class AggregationComponent {

    @Autowired
    private CustomerMasterRepo customerMasterRepo;

    @Autowired
    private CustomerSlaveRepo customerSlaveRepo;

    @Autowired
    private LenderMasterRepo lenderMasterRepo;

    @Autowired
    private LenderSlaveRepo lenderSlaveRepo;

    private static final Logger LOGGER = LoggerFactory.getLogger(AggregationComponent.class);

    public void updateAggregateData(LoansBo bo) {
        updateCustomerAggregation(bo);
        updateLenderAggregation(bo);
    }

    /**
     * Retrieves Customer's aggregate data from DB, combines with incoming data and updates DB.
     *
     * @param bo - Incoming Loan Data.
     */
    public void updateCustomerAggregation(LoansBo bo) {

        CustomerEntity customer = customerSlaveRepo.findByCustomerId(bo.getCustomerId());

        if (customer == null) {
            customer = new CustomerEntity();
            customer.setCustomerId(bo.getCustomerId());
            customer.setTotalInterest(getInterest(bo));
            customer.setTotalRemainingAmount(bo.getRemainingAmount());
            customer.setTotalPenalty(getPenalty(bo));
        } else {
            customer.setTotalInterest(customer.getTotalInterest() + getInterest(bo));
            customer.setTotalRemainingAmount(customer.getTotalRemainingAmount() + bo.getRemainingAmount());
            customer.setTotalPenalty(customer.getTotalPenalty() + getPenalty(bo));
        }

        customerMasterRepo.save(customer);
    }

    /**
     * Retrieves Lender's aggregate data from DB, combines with incoming data and updates DB.
     *
     * @param bo - Incoming Loan Data.
     */
    public void updateLenderAggregation(LoansBo bo) {
        LenderEntity lender = lenderSlaveRepo.findByLenderId(bo.getLenderId());

        if (lender == null) {
            lender = new LenderEntity();
            lender.setLenderId(bo.getLenderId());
            lender.setTotalInterest(getInterest(bo));
            lender.setTotalRemainingAmount(bo.getRemainingAmount());
            lender.setTotalPenalty(getPenalty(bo));
        } else {
            lender.setTotalInterest(lender.getTotalInterest() + getInterest(bo));
            lender.setTotalRemainingAmount(lender.getTotalRemainingAmount() + bo.getRemainingAmount());
            lender.setTotalPenalty(lender.getTotalPenalty() + getPenalty(bo));
        }

        lenderMasterRepo.save(lender);
    }

    /**
     * Calculates the total remaining amount based on existing and new loans.
     *
     * @param loan - Incoming Loan Data.
     */
    private Double getInterest(LoansBo loan) {
        return loan.getRemainingAmount() * loan.getInterest() *
                DateUtils.getDateDifference(loan.getPaymentDate(), new Date()) * 0.01;
    }

    /**
     * Calculates the total penalty based on existing and new loans.
     *
     * @param loan - Incoming Loan Data.
     */
    private Double getPenalty(LoansBo loan) {
        return loan.getRemainingAmount() * loan.getPenalty() *
                DateUtils.getDateDifference(loan.getDueDate(), new Date()) * 0.01;
    }
}
