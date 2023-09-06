package com.loanstore.dtos;

import com.loanstore.models.LoansModel;

/**
 * The type Loans dto.
 */
public class LoanRequestDto extends LoansModel {

    private String paymentDate;

    private String dueDate;

    public String getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(String paymentDate) {
        this.paymentDate = paymentDate;
    }

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }
}
