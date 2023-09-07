package com.loanstore.services;

import com.loanstore.bos.LoansBo;
import com.loanstore.dtos.LoanRequestDto;
import com.loanstore.dtos.LoanResponseDto;

public interface LoanService {

    LoanResponseDto updateLoan(LoanRequestDto dto);
}
