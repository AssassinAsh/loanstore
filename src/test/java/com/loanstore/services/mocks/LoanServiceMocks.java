package com.loanstore.services.mocks;

import com.loanstore.bos.LoansBo;
import com.loanstore.dtos.LoanRequestDto;
import com.loanstore.entities.LoansEntity;
import com.loanstore.utils.DateUtils;

public class LoanServiceMocks {

    public static LoanRequestDto getLoanRequestDto() {
        LoanRequestDto requestDto = new LoanRequestDto();
        requestDto.setPaymentDate("24-03-2020");
        requestDto.setDueDate("20-02-2020");
        requestDto.setLoanId(123);
        requestDto.setCustomerId(455);
        requestDto.setAmount(312131.00);
        requestDto.setInterest(2.0);
        requestDto.setPenalty(1.1);
        requestDto.setLenderId(12124);
        requestDto.setRemainingAmount(21212.00);
        requestDto.setCancelled(false);
        return requestDto;
    }

    public static LoansBo getInvalidLoanBo() throws Exception {
        LoansBo bo = new LoansBo();
        bo.setPaymentDate(DateUtils.getDateFromString("24-03-2020", "dd-mm-yyyy"));
        bo.setDueDate(DateUtils.getDateFromString("20-02-2020", "dd-mm-yyyy"));
        bo.setLoanId(123);
        bo.setCustomerId(455);
        bo.setAmount(312131.00);
        bo.setInterest(2.0);
        bo.setPenalty(1.1);
        bo.setLenderId(12124);
        bo.setRemainingAmount(21212.00);
        bo.setCancelled(false);
        return bo;
    }

    public static LoansBo getValidLoanBo() throws Exception {
        LoansBo bo = new LoansBo();
        bo.setPaymentDate(DateUtils.getDateFromString("24-01-2020", "dd-mm-yyyy"));
        bo.setDueDate(DateUtils.getDateFromString("20-02-2020", "dd-mm-yyyy"));
        bo.setLoanId(123);
        bo.setCustomerId(455);
        bo.setAmount(312131.00);
        bo.setInterest(2.0);
        bo.setPenalty(1.1);
        bo.setLenderId(12124);
        bo.setRemainingAmount(21212.00);
        bo.setCancelled(false);
        return bo;
    }

    public static LoansEntity getLoansEntity() throws Exception {
        LoansEntity entity = new LoansEntity();
        entity.setPaymentDate(DateUtils.getDateFromString("24-01-2020", "dd-mm-yyyy"));
        entity.setDueDate(DateUtils.getDateFromString("20-02-2020", "dd-mm-yyyy"));
        entity.setLoanId(123);
        entity.setCustomerId(455);
        entity.setAmount(312131.00);
        entity.setInterest(2.0);
        entity.setPenalty(1.1);
        entity.setLenderId(12124);
        entity.setRemainingAmount(21212.00);
        entity.setCancelled(false);
        return entity;

    }
}
