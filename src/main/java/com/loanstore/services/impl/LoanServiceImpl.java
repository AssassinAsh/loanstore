package com.loanstore.services.impl;

import com.loanstore.bos.LoansBo;
import com.loanstore.components.AggregationComponent;
import com.loanstore.dtos.LoanRequestDto;
import com.loanstore.dtos.LoanResponseDto;
import com.loanstore.exceptions.InvalidLoanException;
import com.loanstore.mappers.LoansMapper;
import com.loanstore.repositories.master.LoanMasterRepo;
import com.loanstore.services.LoanService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoanServiceImpl implements LoanService {

    private static final Logger LOGGER = LoggerFactory.getLogger(LoanService.class);

    @Autowired
    private LoanMasterRepo loanMasterRepo;

    @Autowired
    private LoansMapper loansMapper;

    @Autowired
    private AggregationComponent aggregationComponent;

    @Override
    public LoanResponseDto updateLoan(LoanRequestDto dto) throws InvalidLoanException {

        // Convert loan DTO to BO.
        LoansBo bo = loansMapper.dtoToBo(dto);

        // Returns Error if Payment Date is greater than Due Date.
        if (bo.getPaymentDate().after(bo.getDueDate())) {

            LOGGER.error("Payment Date: {} is greater than Due Date: {}", bo.getPaymentDate(), bo.getDueDate());

            throw new InvalidLoanException("Payment date cannot be greater than due date.");
        }

        // Triggering aggregation of Data.
        aggregationComponent.updateAggregateData(bo);

        // Saving the Loan data into Database.
        loanMasterRepo.save(loansMapper.boToEntity(bo));

        return new LoanResponseDto(true, "Loan Saved Successfully");
    }
}