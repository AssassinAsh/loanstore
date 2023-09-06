package com.loanstore.services.impl;

import com.loanstore.bos.LoansBo;
import com.loanstore.dtos.LoanRequestDto;
import com.loanstore.dtos.LoanResponseDto;
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

    private final LoanMasterRepo loanMasterRepo;

    private final LoansMapper loansMapper;

    @Autowired
    public LoanServiceImpl(LoanMasterRepo loanMasterRepo, LoansMapper loansMapper) {
        this.loanMasterRepo = loanMasterRepo;
        this.loansMapper = loansMapper;
    }

    @Override
    public LoanResponseDto updateLoan(LoanRequestDto dto) {
        try {
            LoansBo bo = loansMapper.dtoToBo(dto);

            loanMasterRepo.save(loansMapper.boToEntity(bo));

            return new LoanResponseDto(true, "Loan Saved Successfully");
        } catch (Exception ex) {
            LOGGER.error("Error while updating loan data: {}", ex.getMessage());

            return new LoanResponseDto(false, "Unsuccessful", ex.getMessage());
        }
    }
}
